package com.example.drawerfragement;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSecond extends Fragment {

    EditText username;
    EditText password;
    public FragmentSecond(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seconnd,container,false);


        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");
        String data1 = bundle.getString("key1");
        username.setText(data);
        password.setText(data1);



        return view;
    }

}
