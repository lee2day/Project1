package com.g2g.helloworld;

import android.os.Bundle; 
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

public class MailActivity extends Activity implements OnClickListener {
	private AlertDialog aDialog = null;
	
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
	        	// send mail logic
	            setDismiss(aDialog);
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