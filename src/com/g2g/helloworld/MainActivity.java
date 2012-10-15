package com.g2g.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import android.content.Intent;

public class MainActivity extends Activity {

	// �̺�Ʈ ������ �������̽� ��� ���� ���� �� ����
	private OnClickListener btn3_click_listener = new OnClickListener() {
		public void onClick(View v) {
			// ���� activity ���� ��û
			startActivity(new Intent(MainActivity.this, MailActivity.class));
			// �ִϸ��̼� ȿ�� (fade in)
			overridePendingTransition(R.anim.fade, R.anim.hold);
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ���ҽ��� ���ǵǾ� �ִ� ��ư ID
        Button button03 = (Button)findViewById(R.id.button03);
        // ��ư�� ������� ������ ����
        button03.setOnClickListener(btn3_click_listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
