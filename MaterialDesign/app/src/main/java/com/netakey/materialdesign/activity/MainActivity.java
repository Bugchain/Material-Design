package com.netakey.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.netakey.materialdesign.R;
import com.netakey.materialdesign.fragment.BookFragment;
import com.netakey.materialdesign.fragment.HomeFragment;
import com.netakey.materialdesign.fragment.MovieFragment;
import com.netakey.materialdesign.fragment.MusicFragment;
import com.netakey.materialdesign.fragment.StoreFragment;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        BottomNavigationBar.OnTabSelectedListener,NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private int lastPosition = -1;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialActionBar();
        initialBottomNavigationBar();
        displayFragment(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contact,menu);
        return true;
    }


    private void displayFragment(int position){
        if(lastPosition != position){
            Log.d(TAG,"Position : " + position);
            lastPosition = position;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);

            switch (position){
                case 0:
                    transaction.replace(R.id.contentContainer, HomeFragment.newInstance()).commit();
                    updateActionBarTitle(getResources().getString(R.string.home));
                    break;
                case 1:
                    transaction.replace(R.id.contentContainer, BookFragment.newInstance()).commit();
                    updateActionBarTitle(getResources().getString(R.string.books));
                    break;
                case 2:
                    transaction.replace(R.id.contentContainer, MusicFragment.newInstance()).commit();
                    updateActionBarTitle(getResources().getString(R.string.music));
                    break;
                case 3:
                    transaction.replace(R.id.contentContainer, MovieFragment.newInstance()).commit();
                    updateActionBarTitle(getResources().getString(R.string.movie_and_tv));
                    break;
                case 4:
                    transaction.replace(R.id.contentContainer, StoreFragment.newInstance()).commit();
                    updateActionBarTitle(getResources().getString(R.string.store));
                    break;
                default:
                    transaction.replace(R.id.contentContainer, HomeFragment.newInstance()).commit();
                    updateActionBarTitle(getResources().getString(R.string.home));
                    break;
            }
        }

    }
    private void initialActionBar() {
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
            updateActionBarTitle(getResources().getString(R.string.home));
        }
    }


    private void updateActionBarTitle(String title){
        if(actionBar != null)
            actionBar.setTitle(title);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            return true;
        }else if(item.getItemId() == R.id.action_contact){
            startActivity(new Intent(MainActivity.this,ContactActivity.class));
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initialBottomNavigationBar(){
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white, getResources().getString(R.string.home)).setActiveColorResource(R.color.bottom_navigation_bar_color_1))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white, getResources().getString(R.string.books)).setActiveColorResource(R.color.bottom_navigation_bar_color_2))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white, getResources().getString(R.string.music)).setActiveColorResource(R.color.bottom_navigation_bar_color_3))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white, getResources().getString(R.string.movie_and_tv)).setActiveColorResource(R.color.bottom_navigation_bar_color_4))
                .addItem(new BottomNavigationItem(R.drawable.ic_play_shopping_bag_white, getResources().getString(R.string.store)).setActiveColorResource(R.color.bottom_navigation_bar_color_5))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
    }
    @Override
    public void onTabSelected(int position) {
        displayFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
