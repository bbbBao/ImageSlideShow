package com.example.interfragmentcommratingbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ImageFragment extends Fragment {
    View view;
    public int position = 3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image, container, false);

        int[] images = {R.drawable.cat0, R.drawable.cat1, R.drawable.cat2, R.drawable.cat3,
                R.drawable.cat4, R.drawable.cat5};
        int[] starNum = {5, 2, 4, 1, 5, 3};
        String emojiStar = String.valueOf(Character.toChars(0x2B50));

        ImageView img;
        TextView starView;
        img = view.findViewById(R.id.imageView);
        starView = view.findViewById(R.id.starView);


        getParentFragmentManager().setFragmentResultListener("dataForm", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("df1");
                if (data.equals("left")) {position--;}
                if (data.equals("right")) {position++;}
                if (position > 5) {position -= 6;}
                if (position < 0) {position += 6;}

                img.setImageResource(images[position]);

                String starx = "";
                for (int j = 0; j < starNum[position];j++){
                    starx += emojiStar;
                }
                starView.setText(starx);

            }
        });

        return view;
    }

}