package com.example.quickmealswiki;
 
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class FridgeGridAdapter extends BaseAdapter {
    private Context mContext;
    private static final String TAG = "FridgeGridAdapter";
    
    public FridgeGridAdapter(Context c){
        mContext = c;
    }
    
	@Override
	public int getCount() {
		return DataManager.mSelectedIngredients.size();
	}

	@Override
	public Object getItem(int arg0) {
		return DataManager.mSelectedIngredients.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(DataManager.mSelectedIngredients.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
	}
    
}