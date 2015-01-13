package com.example.ui;

import com.example.ui.CustomMarqueeTextView.MaqueeMode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
    CustomMarqueeTextView mCustomMaqueeTextView;
    CustomMarqueeTextView mCustomMaqueeTextView1;
    CustomMarqueeTextView mCustomMaqueeTextView2;
    CustomMarqueeTextView mCustomMaqueeTextView3;    
    TextView tv;
    SeekBar mSeekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCustomMaqueeTextView = (CustomMarqueeTextView) findViewById(R.id.textview);
		mCustomMaqueeTextView1 = (CustomMarqueeTextView) findViewById(R.id.CustomMaqueeTextView01);
		mCustomMaqueeTextView2 = (CustomMarqueeTextView) findViewById(R.id.CustomMaqueeTextView02);
		mCustomMaqueeTextView3 = (CustomMarqueeTextView) findViewById(R.id.CustomMaqueeTextView03);
		tv = (TextView)findViewById(R.id.textView1);
		mSeekBar = (SeekBar)findViewById(R.id.seekBar1);
		mSeekBar.setMax(99);
		mSeekBar.setProgress(0);
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				progress++;
				mCustomMaqueeTextView.setSpeed(progress);
				mCustomMaqueeTextView1.setSpeed(progress);
				mCustomMaqueeTextView2.setSpeed(progress);
				mCustomMaqueeTextView3.setSpeed(progress);
				tv.setText("Speed :"+progress);
			}
		});
		mCustomMaqueeTextView.setText(getString(R.string.hello_world));
		mCustomMaqueeTextView1.setText(getString(R.string.hello_world));
		mCustomMaqueeTextView2.setText(getString(R.string.hello_world));
		mCustomMaqueeTextView3.setText(getString(R.string.hello_world));
		mCustomMaqueeTextView.setMaqueeMode(MaqueeMode.LEFT_RIGHT);
		mCustomMaqueeTextView1.setMaqueeMode(MaqueeMode.RIGHT_LEFT);
		mCustomMaqueeTextView2.setMaqueeMode(MaqueeMode.TOP_BOTTOM);
		mCustomMaqueeTextView3.setMaqueeMode(MaqueeMode.BOTTOM_TOP);
		
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mCustomMaqueeTextView.startScroll();
				mCustomMaqueeTextView1.startScroll();
				mCustomMaqueeTextView2.startScroll();
				mCustomMaqueeTextView3.startScroll();
			}
		});
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mCustomMaqueeTextView.stopScroll();
				mCustomMaqueeTextView1.stopScroll();
				mCustomMaqueeTextView2.stopScroll();
				mCustomMaqueeTextView3.stopScroll();
			}
		});
		findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mCustomMaqueeTextView.reStart();
				mCustomMaqueeTextView1.reStart();
				mCustomMaqueeTextView2.reStart();
				mCustomMaqueeTextView3.reStart();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
