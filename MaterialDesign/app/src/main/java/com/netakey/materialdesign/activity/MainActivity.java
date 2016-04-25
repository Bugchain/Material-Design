package com.netakey.materialdesign.activity;

import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.netakey.materialdesign.R;
import com.netakey.materialdesign.adapter.PlaceAdapter;
import com.netakey.materialdesign.model.Place;
import com.netakey.materialdesign.tools.ItemDecoration;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean isShowFabMenu;
    private FloatingActionButton fabMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialActionBar();

        int space = (int)getResources().getDimension(R.dimen.grid_spacing_x_small);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new ItemDecoration(space));
        recyclerView.setAdapter(new PlaceAdapter(new Place().setup()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(isShowFabMenu){
                    isShowFabMenu = false;
                    displayFabMenu(false);
                }
            }
        });
        fabMenu = (FloatingActionButton) findViewById(R.id.fab);
        fabMenu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:

                isShowFabMenu = !isShowFabMenu;
                displayFabMenu(isShowFabMenu);

                break;
        }
    }

    private void initialActionBar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.app_name));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    private void displayFabMenu(boolean display){
        FloatingActionButton fabMenuEdit = (FloatingActionButton)findViewById(R.id.fab_edit);
        FloatingActionButton fabMenuMail = (FloatingActionButton)findViewById(R.id.fab_mail);
        FloatingActionButton fabMenuPin = (FloatingActionButton)findViewById(R.id.fab_pin);


        FrameLayout.LayoutParams params1 = (FrameLayout.LayoutParams)fabMenuEdit.getLayoutParams();
        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams)fabMenuMail.getLayoutParams();
        FrameLayout.LayoutParams params3 = (FrameLayout.LayoutParams)fabMenuPin.getLayoutParams();

        int fabWidth = fabMenuEdit.getWidth();
        int fabHeight = fabMenuEdit.getHeight();

        if(display){
            params1.rightMargin += (int)(fabWidth * 1.7);
            params1.bottomMargin += (int)(fabHeight * 0.25);
            params2.rightMargin += (int)(fabWidth * 1.5);
            params2.bottomMargin += (int)(fabHeight * 1.5);
            params3.rightMargin += (int)(fabWidth * 0.25);
            params3.bottomMargin += (int)(fabHeight * 1.7);
            fabMenuEdit.setLayoutParams(params1);
            fabMenuMail.setLayoutParams(params2);
            fabMenuPin.setLayoutParams(params3);
            Animation fab1Show = AnimationUtils.loadAnimation(this,R.anim.fab_menu_1_show);
            Animation fab2Show = AnimationUtils.loadAnimation(this,R.anim.fab_menu_2_show);
            Animation fab3Show = AnimationUtils.loadAnimation(this,R.anim.fab_menu_3_show);
            fabMenuEdit.setClickable(true);
            fabMenuMail.setClickable(true);
            fabMenuPin.setClickable(true);
            fabMenuEdit.startAnimation(fab1Show);
            fabMenuMail.startAnimation(fab2Show);
            fabMenuPin.startAnimation(fab3Show);

        }else {
            params1.rightMargin -= (int)(fabWidth * 1.7);
            params1.bottomMargin -= (int)(fabHeight * 0.25);
            params2.rightMargin -= (int)(fabWidth * 1.5);
            params2.bottomMargin -= (int)(fabHeight * 1.5);
            params3.rightMargin -= (int)(fabWidth * 0.25);
            params3.bottomMargin -= (int)(fabHeight * 1.7);
            fabMenuEdit.setLayoutParams(params1);
            fabMenuMail.setLayoutParams(params2);
            fabMenuPin.setLayoutParams(params3);
            Animation fab1Hide = AnimationUtils.loadAnimation(this,R.anim.fab_menu_1_hide);
            Animation fab2Hide = AnimationUtils.loadAnimation(this,R.anim.fab_menu_2_hide);
            Animation fab3Hide = AnimationUtils.loadAnimation(this,R.anim.fab_menu_3_hide);
            fabMenuEdit.setClickable(false);
            fabMenuMail.setClickable(false);
            fabMenuPin.setClickable(false);
            fabMenuEdit.startAnimation(fab1Hide);
            fabMenuMail.startAnimation(fab2Hide);
            fabMenuPin.startAnimation(fab3Hide);
        }
    }

}
