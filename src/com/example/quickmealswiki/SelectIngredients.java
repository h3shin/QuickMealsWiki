package com.example.quickmealswiki;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectIngredients extends Activity {
	protected static final String TAG = "SelectIngredients";
	SelectIngredientsAdapter selectAdapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_ingredients);
		
		selectAdapter = new SelectIngredientsAdapter(this,
				R.layout.select_ingredients, DataManager.mAllIngredients);
		ListView listView = (ListView) findViewById(R.id.select_list_view);

		// Assign adapter to ListView
		listView.setAdapter(selectAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Ingredient ig = (Ingredient) DataManager.GetIngredient(DataManager.mAllIngredients.get(position));
				CheckBox cb = (CheckBox) view.findViewById(R.id.checkbox);
				cb.setChecked(!cb.isChecked());
				cb.setSelected(cb.isChecked());
				DataManager.SetSelected(ig.GetName(), cb.isChecked());
			}
		});
	}
	
	   @Override
	   protected void onResume() {
	      super.onResume();
	   }
	
}