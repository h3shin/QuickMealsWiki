package com.example.quickmealswiki;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
 
public class Fridge extends Activity implements OnTouchListener {
	//private GridView gridView;
	static final String TAG = "Fridge";
	private float downX;
	static final int MIN_DISTANCE = 100;
	private static final int NUM_CHILD_DISPLAY = 2;
	ViewFlipper viewflip;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fridge);
        
        GridView gridView = (GridView) findViewById(R.id.fridge_view);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fridge_open);
        viewflip = (ViewFlipper) findViewById(R.id.view_flipper);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new FridgeGridAdapter(this));
        
        // on long click on any grid item
        gridView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parentView, View view, int position,
					long id) {
				return false;
			}
        });
        
        // on click on any grid item
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
	
	@Override
	protected void onResume() {
	    super.onResume();
	    Log.e(TAG, "resume");
	    DataManager.PopulateSelectedIngredients();
	    Log.e(TAG, "mSelectedIngredients size=" + DataManager.mSelectedIngredients.size());
	    GridView gridView = (GridView) findViewById(R.id.fridge_view);
	    gridView.invalidateViews();
	}
}