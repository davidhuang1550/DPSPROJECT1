package com.example.david.dpsproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by david on 2016-11-15.
 */
public class Profile extends Fragment {
    private View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.profile_fragment,container,false);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.compose);
        if(fab!=null)fab.hide();
        return myView;
    }
}
