package com.example.gokathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HouseAdapter  extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<House> data = null;
    private LayoutInflater inflater = null;

    public HouseAdapter(Context c, int l, ArrayList<House> d) {
        this.mContext = c;
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        ImageView Hu_image = (ImageView) convertView.findViewById(R.id.House_image);
        TextView Hu_title = (TextView) convertView.findViewById(R.id.House_title);
        TextView Hu_whattodo = (TextView) convertView.findViewById(R.id.House_whattodo);
        TextView Hu_cost = (TextView) convertView.findViewById(R.id.House_cost);


        Hu_image.setImageBitmap(data.get(position).image);
        Hu_title.setText(data.get(position).title);
        Hu_whattodo.setText(data.get(position).whattodo);
        Hu_cost.setText(data.get(position).cost);

        return convertView;
    }
}