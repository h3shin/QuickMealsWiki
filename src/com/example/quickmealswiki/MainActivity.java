package com.example.quickmealswiki;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
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
		DataManager.mainActivity = this;
 
		//SharedPreference
		DataManager.pref = getSharedPreferences("pref", 0);
		DataManager.editor = DataManager.pref.edit();
		
		DataManager.init();
		DataManager.PopulateIngredients();
		
		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
 
		// Fridge tab
		Intent intentFridge = new Intent().setClass(this, Fridge.class);
		TabSpec tabSpecFridge = tabHost
		  .newTabSpec("Fridge")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_fridge))
		  .setContent(intentFridge);
 
		// SelectIngredients tab
		Intent intentSelectIngredients = new Intent().setClass(this, SelectIngredients.class);
		TabSpec tabSpecSelectIngredients = tabHost
		  .newTabSpec("SelectIngredients")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_select_ingredients))
		  .setContent(intentSelectIngredients);
 
		// ViewFood tab
		Intent intentViewFood = new Intent().setClass(this, ViewFood.class);
		TabSpec tabSpecViewFood = tabHost
		  .newTabSpec("ViewFood")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_view_food))
		  .setContent(intentViewFood);
 
		// Favorites tab
		Intent intentFavorites = new Intent().setClass(this, Favorites.class);
		TabSpec tabSpecFavorites = tabHost
		  .newTabSpec("Favorites")
		  .setIndicator("", ressources.getDrawable(R.drawable.tab_favorites))
		  .setContent(intentFavorites);
 
		// add all tabs 
		tabHost.addTab(tabSpecFridge);
		tabHost.addTab(tabSpecSelectIngredients);
		tabHost.addTab(tabSpecViewFood);
		tabHost.addTab(tabSpecFavorites);
 
		//set ViewFood tab as default (zero based)
		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case R.id.action_settings:
			//TODO: setting
			break;
		case R.id.action_howto:
			startActivity(new Intent(this, HowTo.class));
			break;
		case R.id.action_about:
			break;
		}
		return false;
		
	}

}
