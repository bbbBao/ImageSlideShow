package com.example.interfragmentcommratingbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonsFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_buttons, container, false);

        Button left = view.findViewById(R.id.left);
        Button right = view.findViewById(R.id.right);





                left.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Bundle result = new Bundle();
                        result.putString("df1","left");
                        getParentFragmentManager().setFragmentResult("dataForm",result);



                    }
                });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle result = new Bundle();
                result.putString("df1","right");
                getParentFragmentManager().setFragmentResult("dataForm",result);



            }
        });




        return view;
    }
}