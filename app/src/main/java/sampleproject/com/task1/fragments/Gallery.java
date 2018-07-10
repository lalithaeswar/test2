package sampleproject.com.task1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import sampleproject.com.task1.R;
import sampleproject.com.task1.adapter.MyAdapter;
import sampleproject.com.task1.model.Item;

public class Gallery extends Fragment {
  private  View view;
    private GridView simpleList;
    private ArrayList images = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) parent.removeView(view);
        } else {
            view = inflater.inflate(R.layout.activity_gallery1, container, false);
            getActivity().setTitle("Gallery");
            //Initialized views
            initView(view);
            initObjects();
        }

        return view;
    }
    private void initView(View v) {

        simpleList =  v.findViewById(R.id.gridView);
    }

    private void initObjects() {
        images.add(new Item("image 1", R.drawable.image1));
        images.add(new Item("image 2", R.drawable.image2));
        images.add(new Item("image 1", R.drawable.image1));
        images.add(new Item("image 1", R.drawable.image1));
        images.add(new Item("image 2", R.drawable.image2));
        images.add(new Item("image 2", R.drawable.image2));
        images.add(new Item("image 1", R.drawable.image1));
        images.add(new Item("image 2", R.drawable.image2));
        images.add(new Item("image 2", R.drawable.image3));
        images.add(new Item("image 2", R.drawable.image4));
        images.add(new Item("image 2", R.drawable.image5));
        images.add(new Item("image 2", R.drawable.image6));
        images.add(new Item("image 2", R.drawable.image2));
        images.add(new Item("image 1", R.drawable.image1));
        images.add(new Item("image 2", R.drawable.image2));
        images.add(new Item("image 2", R.drawable.image3));
        images.add(new Item("image 2", R.drawable.image4));
        images.add(new Item("image 2", R.drawable.image5));
        images.add(new Item("image 2", R.drawable.image6));
        MyAdapter myAdapter = new MyAdapter(getActivity(), R.layout.activity_gridview1, images);
        simpleList.setAdapter(myAdapter);

    }

}
