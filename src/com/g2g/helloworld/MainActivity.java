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

	// 이벤트 리스너 인터페이스 멥버 변수 선언 및 정의
	private OnClickListener btn3_click_listener = new OnClickListener() {
		public void onClick(View v) {
			// 다음 activity 실행 요청
			startActivity(new Intent(MainActivity.this, MailActivity.class));
			// 애니메이션 효과 (fade in)
			overridePendingTransition(R.anim.fade, R.anim.hold);
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 리소스에 정의되어 있는 버튼 ID
        Button button03 = (Button)findViewById(R.id.button03);
        // 버튼에 멤버변수 리스너 설정
        button03.setOnClickListener(btn3_click_listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
