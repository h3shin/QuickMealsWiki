package com.example.quickmealswiki;

import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
 
public class Fridge extends Activity implements OnTouchListener {
	//private GridView gridView;
	static final String TAG = "Fridge";
	private float downX;
	static final int MIN_DISTANCE = 100;
	private static final int NUM_CHILD_DISPLAY = 2;
	ViewFlipper viewflip;
	private Animation translate_right;
	private Animation translate_left;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fridge);
        
        translate_left = AnimationUtils.loadAnimation(this, R.anim.left_out);
        translate_right = AnimationUtils.loadAnimation(this, R.anim.right_in);
        
        GridView gridView = (GridView) findViewById(R.id.fridge_view);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fridge_open);
        viewflip = (ViewFlipper) findViewById(R.id.view_flipper);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new FridgeAdapter(this));
        
        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parentView, View view, int position,
					long id) {
				return false;
			}


        });
        
        gridView.setOnItemClickListener(new OnItemClickListener() {
        	@Override
			public void onItemClick(AdapterView<?> parentView, View view, int position,
					long id) {
			}
        	
        });
        gridView.setOnTouchListener(this);
        linearLayout.setOnTouchListener(this);
    }

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			downX = event.getX();
			break;
		case MotionEvent.ACTION_UP:
			float diff = event.getX() - downX;
			if ( Math.abs(diff) > MIN_DISTANCE && diff > 0) { //swipe to right
				viewflip.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.right_out));
                viewflip.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.left_in));
				viewflip.setDisplayedChild((viewflip.getDisplayedChild()+1)%NUM_CHILD_DISPLAY);
			} else if ( Math.abs(diff) > MIN_DISTANCE ){
				viewflip.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.left_out));
                viewflip.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.right_in));
				viewflip.setDisplayedChild((viewflip.getDisplayedChild()+1)%NUM_CHILD_DISPLAY);
			}
			break;
		}
		return false;
	}
}