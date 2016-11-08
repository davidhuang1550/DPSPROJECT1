package com.example.david.dpsproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by xlhuang3 on 11/8/2016.
 */
public class CreatePostImage  extends Fragment implements View.OnClickListener{
    private View myView;
    private Button Upload;
    private Button Create;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.create_post_image,container,false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.compose);
        if(fab!=null)fab.hide(); // hide it in the create post area

        Upload = (Button)myView.findViewById(R.id.upload);
        Create = (Button)myView.findViewById(R.id.post_button_upload);

        Upload.setOnClickListener(this);
        Create.setOnClickListener(this);


        return myView;

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.upload:
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                getActivity().startActivityForResult(galleryIntent, 1);


                break;
            case R.id.post_button_upload:

                break;



        }
    }
}
