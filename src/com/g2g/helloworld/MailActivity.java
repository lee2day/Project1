package com.g2g.helloworld;

import android.os.Bundle; 
import android.app.Activity;
import android.app.AlertDialog;

import android.util.Log;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailActivity extends Activity implements OnClickListener {
	private AlertDialog aDialog = null;
	private GMailSender sender = null;
	
	// Gmail ����
	private String strUser = "greathaminho@gmail.com";
	private String strPwd  = "skdml!00$smsdjeldp??";
	
	/**
	 * create MailActivity 
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
                
        // �������� ��ư
        Button btnSend = (Button)findViewById(R.id.btn_send);
        // ÷������ ��ư
        Button btnAttach = (Button)findViewById(R.id.btn_attach);
        
        btnSend.setOnClickListener(this);
        btnAttach.setOnClickListener(this);
	}
        
    @Override
    public void onClick(View v) {
    	switch(v.getId()) {
    	case R.id.btn_send :
    		aDialog = createDialog();
    		aDialog.show();
    		break;
    		
		default:
			break;
    	}
    }
	
    /**
     * base ���̾�α�
     * @return ab
     */
	private AlertDialog createDialog() {
	    AlertDialog.Builder ab = new AlertDialog.Builder(this);
	    ab.setMessage("������ �߼��Ͻðڽ��ϱ�?");
	    
	    
	    ab.setPositiveButton("Ȯ��", new DialogInterface.OnClickListener() {
	        @Override
	        public void onClick(DialogInterface arg0, int arg1) {
	        	sender = new GMailSender(strUser, strPwd);
	        	
	        	// send mail logic
	        	EditText edtSender   = (EditText)findViewById(R.id.edt_sender);
	        	EditText edtReceiver = (EditText)findViewById(R.id.edt_receiver);
	        	EditText edtTitle    = (EditText)findViewById(R.id.edt_title); 
	        	EditText edtContent  = (EditText)findViewById(R.id.edt_content);
	        	
	        	try {
		        	String strSender   = edtSender.toString();
		        	String strReceiver = edtReceiver.toString();
		        	String strTitle    = edtTitle.toString();
		        	String strContent  = edtContent.toString();
		        	
		        	sender.sendMail(strTitle, strContent, strSender, strReceiver);
	        	}
	        	catch(Exception e) {
	        		Log.e("SendMail", e.getMessage(), e);
					Toast.makeText(MailActivity.this, "���� ����", Toast.LENGTH_SHORT).show();
	        	}
	        }
	    });
	     
	    ab.setNegativeButton("���", new DialogInterface.OnClickListener() {
	        @Override
	        public void onClick(DialogInterface arg0, int arg1) {
	            setDismiss(aDialog);
	        }
	    });
	     
	    return ab.create();
	}
	
	/**
	 * ���̾�α� ����
	 * @param dialog
	 */
	private void setDismiss(Dialog dialog){
	    if(dialog != null && dialog.isShowing())
	        dialog.dismiss();
	}
}