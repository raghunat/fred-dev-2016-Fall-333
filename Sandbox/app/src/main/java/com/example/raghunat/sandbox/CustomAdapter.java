package com.example.raghunat.sandbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by raghunat on 10/7/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private String[] _textArray;
    private int[] _imageArray;
    private static LayoutInflater inflater = null;

    public CustomAdapter(CustomListViewActivity context, String[] texts, int[] images) {
        _textArray = texts;
        _imageArray = images;
        // use the "inflater" or drawing class from our activity
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return _textArray.length;
    }

    @Override
    public Object getItem(int position) {
        return _textArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Takes items, and creates the view for each one in the list
        View row = inflater.inflate(R.layout.custom_list_view_item, null);
        TextView tv = (TextView)row.findViewById(R.id.text_view);
        // set text view
        tv.setText(_textArray[position]);
        ImageView iv = (ImageView)row.findViewById(R.id.image_view);
        // set image view drawable
        iv.setImageResource(_imageArray[position]);
        // return built view
        return row;
    }

}
