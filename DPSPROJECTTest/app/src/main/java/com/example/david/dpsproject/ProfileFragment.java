package com.example.david.dpsproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by david on 2016-11-16.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    private View myView;
    private Button History;
    private Button Bookmarks;
    private Button Upload;

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.profile_fragment,container,false);

        History = (Button)myView.findViewById(R.id.selfposts);
        Bookmarks = (Button)myView.findViewById(R.id.bookmarks);
        Upload = (Button)myView.findViewById(R.id.uploadprofile);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.compose);
        if(fab!=null)fab.hide();

        History.setOnClickListener(this);
        Bookmarks.setOnClickListener(this);
        Upload.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.selfposts:
             //   listView = (ListView)myView.findViewById(R.id.profile_list_view);
              //  MyPostAdapter adapter = new MyPostAdapter(getActivity(),posts);
              //  listView.setAdapter(adapter);
                break;
            case R.id.bookmarks:

                break;
            case R.id.uploadprofile:

                break;
        }
    }
}
