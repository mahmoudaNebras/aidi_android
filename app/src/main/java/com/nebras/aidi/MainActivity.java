package com.nebras.aidi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private HomeFragment homeFragment;
    private ImageView imgLogo;
    private ChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgLogo = (ImageView) findViewById(R.id.img_logo);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AboutFragment());
            }
        });




       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);

                } else {

                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationView navigationViewBottom = (NavigationView) findViewById(R.id.navigation_drawer_bottom);
        navigationViewBottom.setItemIconTintList(null);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(this);

        chatFragment = new ChatFragment();

        homeFragment = new HomeFragment();

        replaceFragment(homeFragment);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_filter) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            replaceFragment(homeFragment);
            // Handle the camera action
        } else if (id == R.id.nav_fav) {

        } else if (id == R.id.nav_chat) {
            replaceFragment(chatFragment);

        } else if (id == R.id.nav_notifications) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_about) {
            replaceFragment(new AboutFragment());

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void replaceFragment (Fragment fragment){
        FragmentTransaction fragmentTransaction =   getSupportFragmentManager().beginTransaction();

        String backStateName = fragment.getClass().getName();



        Fragment fragment1 = getSupportFragmentManager().findFragmentByTag(backStateName);

        if(fragment1!=null && fragment.getClass().getName().equals(HomeFragment.class.getName())) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }


        if(fragment1!=null&&!fragment1.getTag().equals(HomeFragment.class.getName())) {
            fragmentTransaction.replace(R.id.fragment_container, fragment1, backStateName).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.addToBackStack(backStateName);
            fragmentTransaction.commit();


        }else  {
            Fragment fr1 = getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getName());
            if(fr1!=null&&fr1.getTag().equals(backStateName))
                return;

            fragmentTransaction.replace(R.id.fragment_container, fragment, backStateName).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            if(!fragment.getClass().getName().equals(HomeFragment.class.getName())) {

                fragmentTransaction.addToBackStack(backStateName);

            }
            fragmentTransaction.commit();


        }

    }

}
