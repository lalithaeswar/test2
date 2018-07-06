package sampleproject.com.task1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import sampleproject.com.task1.config.CircleTransform;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
      android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      Resources mResources;
       ImageView mImageView;
      Bitmap mBitmap;



        // Get the Resources
        mResources = getResources();

        mImageView = findViewById(R.id.iv);


        // Get the bitmap from drawable resources
//        mBitmap = BitmapFactory.decodeResource(mResources,R.drawable.sample1);
//        float cornerRadius = 50.0f;
//                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
//                        mResources,
//                        mBitmap
//                );
//
//                roundedBitmapDrawable.setCornerRadius(cornerRadius);
//                roundedBitmapDrawable.setAntiAlias(true);
//                mImageView.setImageDrawable(roundedBitmapDrawable);

        Picasso.get()
                .load(R.drawable.sample1)
                .resize(50, 50)
                .centerCrop()
                .transform(new CircleTransform())
                .into(mImageView);
            }




    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pager, menu);
        return true;
    }

}
