package com.example.quickmealswiki;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
public class SelectIngredientsAdapter extends ArrayAdapter<Ingredient> {

	private static final String TAG = "SelectIngredientsAdapter";
	private ArrayList<Ingredient> ingredientsList;
	Context mContext;

	public SelectIngredientsAdapter(Context context, int textViewResourceId,
			ArrayList<Ingredient> objects) {
		super(context, textViewResourceId, objects);
		this.ingredientsList = new ArrayList<Ingredient>();
		this.ingredientsList.addAll(objects);
		this.mContext = context;
		Log.e(TAG,"Constructor");
	}

	private class ViewHolder {
		TextView name;
		CheckBox selected;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.e(TAG,"getView");
		ViewHolder holder = null;
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.ingredients_list_item, null);

			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.label);
			holder.selected = (CheckBox) convertView
					.findViewById(R.id.checkbox);
			convertView.setTag(holder);
			holder.selected.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					CheckBox cb = (CheckBox) v;
					Ingredient ig = (Ingredient) cb.getTag();
					DataManager.SetSelected(ig.GetName(), cb.isChecked());
				}
			});
		}
	    holder = (ViewHolder) convertView.getTag();
		Ingredient ig = DataManager.mAllIngredients.get(position);
		holder.name.setText(ig.GetName());
		holder.selected.setChecked(ig.IsSelected());
		holder.selected.setSelected(ig.IsSelected());
		holder.selected.setTag(ig);
		return convertView;
	}
}