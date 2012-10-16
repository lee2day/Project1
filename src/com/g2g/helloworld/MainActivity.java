package com.g2g.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {
	// OnClick 이벤트 처리
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button03 :
			// 다음 activity 실행 요청
			startActivity(new Intent(MainActivity.this, MailActivity.class));
			// 애니메이션 효과 (fade in)
			overridePendingTransition(R.anim.fade, R.anim.hold);
			break;
			
		default :
			break;
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 리소스에 정의되어 있는 버튼 ID
        Button button03 = (Button)findViewById(R.id.button03);
        // 버튼에 멤버변수 리스너 설정
        button03.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
