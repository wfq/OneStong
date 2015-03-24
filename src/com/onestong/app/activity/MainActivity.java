package com.onestong.app.activity;

import android.os.Bundle;
import android.view.Window;

import com.onestong.app.R;
import com.onestong.app.engine.BaseActivity;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}

}
