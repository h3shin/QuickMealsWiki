package com.example.quickmealswiki;
 
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class FridgeAdapter extends BaseAdapter {
    private Context mContext;
   // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.v_bacon, R.drawable.v_bok_choy,
            R.drawable.v_chinese_cabbage, R.drawable.v_cucumber,
            R.drawable.v_hot_pepper, R.drawable.v_pepper,
            R.drawable.v_radish, R.drawable.v_sausage
    };
    
    public FridgeAdapter(Context c){
        mContext = c;
    }
    
	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		return mThumbIds[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
	}
    
}