package sampleproject.com.task1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


import java.util.ArrayList;

import sampleproject.com.task1.R;
import sampleproject.com.task1.adapter.MyAdapter;
import sampleproject.com.task1.model.Item;

public class Gallery extends AppCompatActivity {
    GridView simpleList;
    ArrayList images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery1);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Gallery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        simpleList = (GridView) findViewById(R.id.gridView);
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
        MyAdapter myAdapter = new MyAdapter(this, R.layout.activity_gridview1, images);
        simpleList.setAdapter(myAdapter);

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
