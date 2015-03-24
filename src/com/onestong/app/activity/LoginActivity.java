package com.onestong.app.activity;

import com.onestong.app.R;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class LoginActivity extends ActionBarActivity {

	private ImageView logos, logox;
	private EditText userName, passWord;
	private Button bt_login;
	private LayoutParams lps, lpx;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();
    }

	private void initView() {
		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		logos = (ImageView) findViewById(R.id.login01);
		logox = (ImageView) findViewById(R.id.login02);
		userName = (EditText) findViewById(R.id.username);
		passWord = (EditText) findViewById(R.id.password);
		bt_login = (Button) findViewById(R.id.bt_login);
		lps = (LayoutParams) logos.getLayoutParams();
		lps.width = screenWidth/3;
		lpx = (LayoutParams) logox.getLayoutParams();
		lpx.width = screenWidth/2;
	}

}
