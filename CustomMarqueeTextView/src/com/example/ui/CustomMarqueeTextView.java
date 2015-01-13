package com.example.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;
/**
 * 自定義跑馬燈TextView
 * @author andy
 *
 */
public class CustomMarqueeTextView extends TextView implements Runnable{
	private int curScrollX;
	private int curScrollY;
	private boolean isStop;
	private boolean isMaquee = false;
	private int textWidth = 0;
	private int textHeight = 0;
	private int speed = 2;
	private final int  MAX_SPEED = 100;
	private final int  MIN_SPEED = 1;
	MaqueeMode mMaqueeMode = MaqueeMode.BOTTOM_TOP;
	
	public void setMaqueeMode(MaqueeMode mMaqueeMode) {
		this.mMaqueeMode = mMaqueeMode;
	}
	public enum MaqueeMode{
		
		LEFT_RIGHT,
		RIGHT_LEFT,
		TOP_BOTTOM,
		BOTTOM_TOP
		
	}
	public CustomMarqueeTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public CustomMarqueeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public CustomMarqueeTextView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if(!isMaquee){
			getTextWidth();
			getTextHeight();
			isMaquee = true;
		}
	}
	private void getTextWidth(){
		Paint paint = this.getPaint();
		String text = this.getText().toString();
		textWidth = (int) paint.measureText(text);
	}
	private void getTextHeight(){
		Paint paint = this.getPaint();
		String text = this.getText().toString();
		Rect textBounds = new Rect();
		paint.getTextBounds(text, 0, text.length(), textBounds);
		textHeight = textBounds.height();
	}
	public void setSpeed(int speed){
		if(speed>=MIN_SPEED&&speed<=MAX_SPEED){
			this.speed = speed;
		}else if(speed<MIN_SPEED){
			this.speed = MIN_SPEED;
		}else if(speed<MAX_SPEED){
			this.speed = MAX_SPEED;	
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch (mMaqueeMode) {
		case LEFT_RIGHT:
			curScrollX -= speed;
			scrollTo(curScrollX, 0);
			if(isStop){
				return;
			}
			if(getScrollX()<=-(this.getWidth())){
				scrollTo(textWidth, 0);
				curScrollX = textWidth;
			}
			break;
		case RIGHT_LEFT:
			curScrollX += speed;
			scrollTo(curScrollX, 0);
			if(isStop){
				return;
			}
			if(getScrollX()>=(this.getWidth())){
				scrollTo(getWidth(), 0);
				curScrollX = -this.getWidth();
			}
			break;
		case TOP_BOTTOM:
			curScrollY -= speed;
			scrollTo(0, curScrollY);
			if(isStop){
				return;
			}
			if(getScrollY()<=-(this.getHeight())){
				scrollTo(textHeight, 0);
				curScrollY = textHeight;
			}
			break;
		case BOTTOM_TOP:
			curScrollY += speed;
			scrollTo(0, curScrollY);
			if(isStop){
				return;
			}
			if(getScrollY()>=(this.getHeight())){
				scrollTo(0, this.getHeight());
				curScrollY = -this.getHeight();
			}
			break;
		default:
			break;
		}
		
		postDelayed(this, 5);
	}
    public void startScroll(){
    	    isStop = false;
    	    this.removeCallbacks(this);
    	    post(this);
    } 
    public void stopScroll(){
    	    isStop = true;
    }
    public void reStart(){
    	   curScrollX = 0;
    	   curScrollY = 0;
    	   startScroll();
    }
} 
