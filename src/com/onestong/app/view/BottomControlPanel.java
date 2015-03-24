package com.onestong.app.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.onestong.app.R;
import com.onestong.app.domain.Constant;

public class BottomControlPanel extends RelativeLayout implements OnClickListener {

	private Context mContext;
	private ImageText mEventBtn;
	private ImageText mYixinBtn;
	private ImageText mFoundBtn;
	private ImageText mMeBtn;
	private int DEFAULT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);
	private BottomPanelCallback mBottomCallback;
	private List<ImageText> viewList = new ArrayList<ImageText>();
	
	public interface BottomPanelCallback {
		public void onBottomPanelClick (int itemId);
	}
	
	public BottomControlPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		mEventBtn = (ImageText) findViewById(R.id.btn_event);
		mYixinBtn = (ImageText) findViewById(R.id.btn_yixin);
		mFoundBtn = (ImageText) findViewById(R.id.btn_found);
		mMeBtn = (ImageText) findViewById(R.id.btn_me);
		setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
		viewList.add(mEventBtn);
		viewList.add(mYixinBtn);
		viewList.add(mFoundBtn);
		viewList.add(mMeBtn);
	}
	
	public void initBottomPanel() {
		if (mEventBtn != null) {
			mEventBtn.setImage(R.drawable.event_unselected);
			mEventBtn.setText("事件");
		}
		if (mYixinBtn != null) {
			mYixinBtn.setImage(R.drawable.yixin_unselected);
			mYixinBtn.setText("易信");
		}
		if (mFoundBtn != null) {
			mFoundBtn.setImage(R.drawable.found_unselected);
			mFoundBtn.setText("发现");
		}
		if (mMeBtn != null) {
			mMeBtn.setImage(R.drawable.me_unselected);
			mMeBtn.setText("我");
		}
		setBtnListener();
	}

	private void setBtnListener() {
		int num = this.getChildCount();
		for (int i = 0; i < num; i++) {
			View v = getChildAt(i);
			if (v != null) {
				v.setOnClickListener(this);
			}
		}
	}
	
	public void setBottomCallback(BottomPanelCallback bottomCallback){  
        mBottomCallback = bottomCallback;  
    }

	@Override
	public void onClick(View v) {
		initBottomPanel();
		int index = -1;
		switch(v.getId()) {
		case R.id.btn_event:
			index = Constant.BTN_FLAG_EVENT;
			mEventBtn.setChecked(Constant.BTN_FLAG_EVENT);
			break;
		case R.id.btn_yixin:
			index = Constant.BTN_FLAG_YIXIN;
			mYixinBtn.setChecked(Constant.BTN_FLAG_YIXIN);
			break;
		case R.id.btn_found:
			index = Constant.BTN_FLAG_FOUND;
			mFoundBtn.setChecked(Constant.BTN_FLAG_FOUND);
			break;
		case R.id.btn_me:
			index = Constant.BTN_FLAG_ME;
			mMeBtn.setChecked(Constant.BTN_FLAG_ME);
			break;
		default:break;
		}
		if (mBottomCallback != null) {
			mBottomCallback.onBottomPanelClick(index);
		}
	}
	
	public void defaultBtnChecked() {
		if (mEventBtn != null) {
			mEventBtn.setChecked(Constant.BTN_FLAG_EVENT);
		}
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		layoutItems(left, top, right, bottom);
	}

	/**最左边和最右边的view由母布局的padding进行控制位置。这里需对第2、3个view的位置重新设置 
     * @param left 
     * @param top 
     * @param right 
     * @param bottom 
     */
	private void layoutItems(int left, int top, int right, int bottom) {
		int n = getChildCount();  
        if(n == 0){  
            return;  
        }  
        int paddingLeft = getPaddingLeft();  
        int paddingRight = getPaddingRight();  
        Log.i("BottomControlPanel", "paddingLeft = " + paddingLeft + " paddingRight = " + paddingRight);  
        int width = right - left;  
        int height = bottom - top;  
        Log.i("BottomControlPanel", "width = " + width + " height = " + height);  
        int allViewWidth = 0;  
        for(int i = 0; i< n; i++){  
            View v = getChildAt(i);  
            Log.i("BottomControlPanel", "v.getWidth() = " + v.getWidth());  
            allViewWidth += v.getWidth();  
        }  
        int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);  
        Log.i("BottomControlPanel", "blankV = " + blankWidth );  
  
        LayoutParams params1 = (LayoutParams) viewList.get(1).getLayoutParams();  
        params1.leftMargin = blankWidth;  
        viewList.get(1).setLayoutParams(params1);  
  
        LayoutParams params2 = (LayoutParams) viewList.get(2).getLayoutParams();  
        params2.leftMargin = blankWidth;  
        viewList.get(2).setLayoutParams(params2);
	}

}
