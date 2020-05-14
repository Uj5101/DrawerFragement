package com.example.drawerfragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MainFragment extends Fragment {


    EditText usernameInput;
    EditText passwordInput;
    Button submit;

    public MainFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        usernameInput = view.findViewById(R.id.usernameInput);
        passwordInput = view.findViewById(R.id.passwordInput);
        submit= view.findViewById(R.id.submit);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("key",usernameInput.getText().toString());
                        bundle.putString("key1",passwordInput.getText().toString());
                        FragmentSecond fragmentSecond = new FragmentSecond();
                        fragmentSecond.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.container_fragment,fragmentSecond).commit();
                    }
                }
        );
        return view;
    }
}
