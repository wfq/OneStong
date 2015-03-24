package com.onestong.app.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onestong.app.R;
import com.onestong.app.domain.Constant;

public class ImageText extends LinearLayout {

	private Context mContext;
	private ImageView mImageView;
	private TextView mTextView;
	private final static int DEFAULT_IMAGE_WIDTH = 50;
	private final static int DEFAULT_IMAGE_HEIGHT = 50;
	private int CHECKED_COLOR = Color.rgb(178, 211, 54);
	private int UNCHECKED_COLOR = Color.rgb(102, 102, 102);

	public ImageText(Context context) {
		super(context);
		mContext = context;
	}

	public ImageText(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.image_text_layout, this,
				true);
		mImageView = (ImageView) findViewById(R.id.image_image_text);
		mTextView = (TextView) findViewById(R.id.text_image_text);
	}

	public void setImage(int id) {
		if (mImageView != null) {
			mImageView.setImageResource(id);
			setImageSize(DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
		}
	}

	public void setText(String s) {
		if (mTextView != null) {
			mTextView.setText(s);
			mTextView.setTextColor(UNCHECKED_COLOR);
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// 返回true，DOWN 事件传递给 它的onTouchEvent，从此便不往下面传递了
		return true;
	}

	private void setImageSize(int w, int h) {
		if (mImageView != null) {
			ViewGroup.LayoutParams params = mImageView.getLayoutParams();
			params.width = w;
			params.height = h;
			mImageView.setLayoutParams(params);
		}
	}

	public void setChecked(int itemID) {
		if (mTextView != null) {
			mTextView.setTextColor(CHECKED_COLOR);
		}
		int checkDrawableId = -1;
		switch (itemID) {
		case Constant.BTN_FLAG_EVENT:
			checkDrawableId = R.drawable.event_selected;
			break;
		case Constant.BTN_FLAG_YIXIN:
			checkDrawableId = R.drawable.yixin_selected;
			break;
		case Constant.BTN_FLAG_FOUND:
			checkDrawableId = R.drawable.found_selected;
			break;
		case Constant.BTN_FLAG_ME:
			checkDrawableId = R.drawable.me_selected;
			break;
		default:break;
		}
		if (mImageView != null) {
			mImageView.setImageResource(checkDrawableId);
		}
	}
}
