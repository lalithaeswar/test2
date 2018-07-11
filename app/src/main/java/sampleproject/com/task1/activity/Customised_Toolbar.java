package sampleproject.com.task1.activity;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;

import sampleproject.com.task1.R;

import static android.content.Intent.EXTRA_TITLE;

public class Customised_Toolbar extends AppCompatActivity {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customised__toolbar);
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "image2");
        supportPostponeEnterTransition();
        initViews();


        //  String itemTitle = getIntent().getStringExtra(EXTRA_TITLE);

        //collapsingToolbarLayout.setTitle(itemTitle);

    }

    private void initViews() {
        context = getApplicationContext();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //collaspingtoolbar
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "R.drawable.image2");
        supportPostponeEnterTransition();

    }

    //to support the toolbar backbutton
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
