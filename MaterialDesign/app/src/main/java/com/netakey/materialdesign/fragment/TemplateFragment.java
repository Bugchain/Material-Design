package com.netakey.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netakey.materialdesign.R;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class TemplateFragment extends Fragment{

    public static TemplateFragment newInstance(){
        return new TemplateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_template,container,false);

        return rootView;
    }
    
}
