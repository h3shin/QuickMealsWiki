package com.example.quickmealswiki;

public class Constants {
	
	public enum FoodType {
		MEAT, VEGGIE, FISH, SAUCE, FRUIT, MISC
	}
	
	public String GetFoodType ( FoodType foodtype ) {
		String result = null;
		switch ( foodtype ) {
		case MEAT:
			result = "meat";
		case VEGGIE:
			result = "veggie";
		case FISH:
			result = "fish";
		case SAUCE:
			result = "sauce";
		case FRUIT:
			result = "fruit";
		case MISC:
			result = "misc";
		}
		return result;
	}
	
}