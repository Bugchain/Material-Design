package com.netakey.materialdesign.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.netakey.materialdesign.R;
import com.netakey.materialdesign.model.Place;
import com.netakey.materialdesign.tools.Const;
import com.netakey.materialdesign.tools.Utils;

/**
 * Created by POSEIDON on 9/4/2559.
 */
public class PlaceDetailActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        initialToolbar();

        fab = (FloatingActionButton)findViewById(R.id.fab);

        Place place = (Place)getIntent().getExtras().get(Const.EXTRA_OBJECT);

        if(place != null) {
            ImageView image = (ImageView) findViewById(R.id.headerImage);
            image.setImageResource(place.getImageId());
            TextView textTitle = (TextView) findViewById(R.id.textTitle);
            TextView textDes = (TextView) findViewById(R.id.textDescription);

            if (Utils.isAndroidVersionAboveLollipop()) {
                ViewCompat.setTransitionName(image, Const.SHARE_ELEMENT);
            }
            textTitle.setText(place.getTitle());
            textDes.setText(place.getDescription());

        }
    }

    private void initialToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Animation fabIn = AnimationUtils.loadAnimation(this,R.anim.fab_in_detail);
        fab.startAnimation(fabIn);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Animation fabIn = AnimationUtils.loadAnimation(this,R.anim.fab_out_detail);
        fab.startAnimation(fabIn);
        super.onBackPressed();

    }
}
