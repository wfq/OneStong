package com.onestong.app.engine;

import com.onestong.app.util.ActivityCollector;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 所有活动的父类
 * 
 * @author wangfangqi
 *
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 判断当前类名
		Log.d("BaseActivity", getClass().getSimpleName());
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

}
