package sampleproject.com.task1.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import sampleproject.com.task1.R;
import sampleproject.com.task1.fragments.CollapsingActivity;
import sampleproject.com.task1.fragments.Gallery;
import sampleproject.com.task1.fragments.ProfilePage;

public class navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private FragmentTransaction fragmentTransaction;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initViews();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
// Default Fragment
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ProfilePage fragment = new ProfilePage();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }
    private void initViews()
    {
        drawer =  findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fab: Snackbar.make(v, "welcome snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            getSupportActionBar().setTitle("camera");


            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            Gallery fragment = new Gallery();
            fragmentTransaction.replace(R.id.container, fragment);
            try {
                getSupportActionBar().setTitle("Gallery");
            }catch(NullPointerException e){

            }
            fragmentTransaction.commit();

        } else if (id == R.id.nav_slideshow) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            CollapsingActivity fragment = new CollapsingActivity();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);

           try {
               getSupportActionBar().setTitle("Books");
           }catch(NullPointerException e){

            }
            fragmentTransaction.commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
