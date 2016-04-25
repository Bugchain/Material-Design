package com.netakey.materialdesign.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.netakey.materialdesign.R;
import com.netakey.materialdesign.fragment.HomeFragment;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialActionBar();
        initialBottomNavigationBar();


    }

    private void displayFragment(int position){
        switch (position){
            case 0:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentContainer, HomeFragment.newInstance()).commit();
                break;
            case 1:
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;
        }

    }

    private void initialActionBar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
            actionBar.setTitle(getResources().getString(R.string.home));
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

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
                .addItem(new BottomNavigationItem(R.drawable.ic_my_library_music_white, getResources().getString(R.string.music)).setActiveColorResource(R.color.bottom_navigation_bar_color_3))
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
}

