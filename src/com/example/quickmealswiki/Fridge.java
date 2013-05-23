package com.example.quickmealswiki;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
 
public class Fridge extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        TextView textview = new TextView(this);
        textview.setText("This is Fridge tab");
        setContentView(textview);
    }
}