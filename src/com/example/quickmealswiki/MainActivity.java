package com.example.quickmealswiki;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
 
		// Android tab
		Intent intentAndroid = new Intent().setClass(this, Fridge.class);
		TabSpec tabSpecAndroid = tabHost
		  .newTabSpec("Android")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_fridge))
		  .setContent(intentAndroid);
 
		// Apple tab
		Intent intentApple = new Intent().setClass(this, SelectIngredients.class);
		TabSpec tabSpecApple = tabHost
		  .newTabSpec("Apple")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_select_ingredients))
		  .setContent(intentApple);
 
		// Windows tab
		Intent intentWindows = new Intent().setClass(this, ViewFood.class);
		TabSpec tabSpecWindows = tabHost
		  .newTabSpec("Windows")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_view_food))
		  .setContent(intentWindows);
 
		// Blackberry tab
		Intent intentBerry = new Intent().setClass(this, Favorites.class);
		TabSpec tabSpecBerry = tabHost
		  .newTabSpec("Berry")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_favorites))
		  .setContent(intentBerry);
 
		// add all tabs 
		tabHost.addTab(tabSpecAndroid);
		tabHost.addTab(tabSpecApple);
		tabHost.addTab(tabSpecWindows);
		tabHost.addTab(tabSpecBerry);
 
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
