package sampleproject.com.task1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import sampleproject.com.task1.R;
import sampleproject.com.task1.config.CircleTransform;

public class ProfilePage extends Fragment {
    private View view;
    private ImageView mImageView;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) parent.removeView(view);
        } else {
            view = inflater.inflate(R.layout.activity_profile_page, container, false);
            //Initialized views
            initView(view);
            Picasso.get()
                    .load(R.drawable.sample1)
                    .resize(50, 50)
                    .centerCrop()
                    .transform(new CircleTransform())
                    .into(mImageView);
        }
        
        return view;
    }
    private void initView(View v) {
        mImageView = v.findViewById(R.id.iv);
    }


}
