package com.example.quickmealswiki;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
 
public class SelectIngredients extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        TextView textview = new TextView(this);
        textview.setText("This is Select Ingredients tab");
        setContentView(textview);
    }
}