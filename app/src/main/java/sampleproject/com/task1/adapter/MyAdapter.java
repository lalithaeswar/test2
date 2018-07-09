package sampleproject.com.task1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sampleproject.com.task1.R;
import sampleproject.com.task1.model.Item;

public class MyAdapter extends ArrayAdapter {

    ArrayList birdList = new ArrayList<Item>();


    public MyAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        birdList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_gridview1, null);
        TextView textView = (TextView) v.findViewById(R.id.text);
        ImageView imageView = (ImageView) v.findViewById(R.id.image);

        Item item = (Item) birdList.get(position);
        textView.setText(item.getbirdName());
        imageView.setImageResource(item.getbirdImage());
        return v;

    }

}
