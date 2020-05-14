package com.example.drawerfragement;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.fragment.app.Fragment;

public class fragment_third extends Fragment {


    static final  int REQUEST_IMAGE_CAPTURE = 1;
    Button ibutton;
    ImageView imageView;

    public fragment_third(){

    }

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third,container,false);

        ibutton = view.findViewById(R.id.ibutton);
        imageView = view.findViewById(R.id.imageView);

        ibutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
                    }
                }
        );

        return view;
    }

}
