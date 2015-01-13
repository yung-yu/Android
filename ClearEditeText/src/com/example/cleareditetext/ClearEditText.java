package com.example.cleareditetext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
/**
 * 可以點擊清除的EditText
 * @author andy
 *
 */
public class ClearEditText extends EditText 
implements OnFocusChangeListener,OnTouchListener {
	private Drawable xD;
    OnFocusChangeListener sOnFocusChangeListener;
    OnTouchListener sOnTouchListener;
	@Override
	public void setOnFocusChangeListener(OnFocusChangeListener l) {
		// TODO Auto-generated method stub
		sOnFocusChangeListener=l;
		
	}
	@Override
	public void setOnTouchListener(OnTouchListener l) {
		// TODO Auto-generated method stub
		sOnTouchListener=l;

	}
	public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}
	public ClearEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}
	public ClearEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	public void init(Context context){
        xD = getResources().getDrawable(getDefaultClearIconId());
        xD.setBounds(0, 0, xD.getIntrinsicWidth(), xD.getIntrinsicHeight());
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);

	}
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_UP){
			if (event.getX()>(view.getWidth()-(xD.getIntrinsicWidth()+view.getPaddingRight()))){
				((EditText)view).setText("");
				return false;
			}
		}
		if(sOnTouchListener!=null){
			return sOnTouchListener.onTouch(view, event);
		}
		return false;
	}
  

	@Override
	protected void onTextChanged(CharSequence text, int start,
			int lengthBefore, int lengthAfter) {
		// TODO Auto-generated method stub
		super.onTextChanged(text, start, lengthBefore, lengthAfter);
		if(isFocused()){
			if(text.length()>0){
				setIconVisible(true);
			}else{
				setIconVisible(false);
			}
		}
	}
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		if(hasFocus){
			if(getText().length()>0){
				setIconVisible(true);
			}else{
				setIconVisible(false);
			}
		}
		if(sOnFocusChangeListener!=null){
			sOnFocusChangeListener.onFocusChange(v, hasFocus);
		}
	}

	private int getDefaultClearIconId() {
        int id = getResources()
                        .getIdentifier("ic_clear", "drawable", "android");
        if (id == 0) {
                id = android.R.drawable.presence_offline;
        }
        return id;
   }
  public void setIconVisible(boolean isVsiable){
	  Drawable mDrawable=isVsiable?xD:null;
	  setCompoundDrawables(null, null, mDrawable, null);
  }


}
