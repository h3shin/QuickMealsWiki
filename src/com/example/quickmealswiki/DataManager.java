package com.example.quickmealswiki;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.example.quickmealswiki.Constants.FoodType;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class DataManager {
	private static final String TAG = "DataManager";

	public static Activity mainActivity;

	// Used in FridgeGridAdapter
	public static ArrayList<Integer> mSelectedIngredients;

	// Used in SelectIngredientAdapter
	public static ArrayList<String> mAllIngredients;

	// The key string is used for sharedpreference
	private static Map<String, Ingredient> mIngredients;

	// The "selected" status of an ingredient is saved as SharedPreference
	static SharedPreferences pref;
	static Editor editor;

	public static void PopulateIngredients() {
		for (Entry<String, Ingredient> entry : mIngredients.entrySet()) {
			Ingredient ig = entry.getValue();
			mAllIngredients.add(ig.GetName());
			if (ig.IsSelected()) {
				mSelectedIngredients.add(ig.GetPicture());
			}
		}
	}

	public static void PopulateSelectedIngredients() {
		mSelectedIngredients.clear();
		for (Entry<String, Ingredient> entry : mIngredients.entrySet()) {
			Ingredient ig = entry.getValue();
			if (ig.IsSelected()) {
				mSelectedIngredients.add(ig.GetPicture());
				Log.e(TAG,"adding " + ig.GetName());
			}
		}
	}

	public static boolean IsSelected(String name) {
		return pref.getBoolean(name, false);
	}

	public static void SetSelected(String name, Boolean state) {
		editor.putBoolean(name, state);
		editor.commit();
	}

	public static void init() {
		// Use of Treemap will sort the keys
		mIngredients = new TreeMap<String, Ingredient>();
		mAllIngredients = new ArrayList<String>();
		mSelectedIngredients = new ArrayList<Integer>();
		mIngredients.put("Bacon", new Ingredient("Bacon", FoodType.MEAT, R.drawable.v_bacon));
		mIngredients.put("Bok Choy", new Ingredient("Bok Choy", FoodType.VEGGIE, R.drawable.v_bok_choy));
		mIngredients.put("Chinese Cabbage",	new Ingredient("Chinese Cabbage", FoodType.VEGGIE, R.drawable.v_chinese_cabbage));
		mIngredients.put("Cucumber", new Ingredient("Cucumber", FoodType.VEGGIE, R.drawable.v_cucumber));
		mIngredients.put("Hot Pepper", new Ingredient("Hot Pepper", FoodType.VEGGIE, R.drawable.v_hot_pepper));
		mIngredients.put("Pepper", new Ingredient("Pepper", FoodType.VEGGIE, R.drawable.v_pepper));
		mIngredients.put("Radish", new Ingredient("Radish", FoodType.VEGGIE, R.drawable.v_radish));
		mIngredients.put("Sausage", new Ingredient("Sausage", FoodType.MEAT, R.drawable.v_sausage));
	}

	public static Ingredient GetIngredient(String name) {
		return mIngredients.get(name);
	}

}