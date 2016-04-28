package com.netakey.materialdesign.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netakey.materialdesign.R;
import com.netakey.materialdesign.adapter.PlaceAdapter;
import com.netakey.materialdesign.model.Place;
import com.netakey.materialdesign.tools.ItemDecoration;

/**
 * Created by POSEIDON on 25/4/2559.
 */

public class HomeFragment extends Fragment{

    private SwipeRefreshLayout swipeRefreshLayout;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);

        int space = (int)getResources().getDimension(R.dimen.grid_spacing_x_small);
        int column = getResources().getInteger(R.integer.place_grid_column);

        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(),R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      swipeRefreshLayout.setRefreshing(false);
                    }
                },1500);
            }
        });
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),column));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new ItemDecoration(space));
        recyclerView.setAdapter(new PlaceAdapter(new Place().setup()));

        return rootView;
    }
}
