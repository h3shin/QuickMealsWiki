package com.example.quickmealswiki;

import com.example.quickmealswiki.Constants.FoodType;

public class Ingredient {
	
	//TODO: remove name since hash map key is name?
	private String name = null;
	private FoodType foodtype = null;
	private int pic = 0;
	
	public Ingredient( String n, FoodType f, int p ) {
		this.name = n;
		this.foodtype = f;
		this.pic = p;
	}
	
	/* Getters */
	public String GetName() {
		return name;
	}
	
	public FoodType GetFoodType() {
		return foodtype;
	}
	
	public Integer GetPicture() {
		return pic;
	}
	
	/* Setters */
	public void SetName( String n ) {
		this.name = n;
	}
	
	public void SetFoodType( FoodType f ) {
		this.foodtype = f;
	}
	
	public Boolean IsSelected() {
		return DataManager.IsSelected(name);
	}
	
	public void SetSelected( Boolean b ) {
		DataManager.SetSelected(name, b);
	}
}