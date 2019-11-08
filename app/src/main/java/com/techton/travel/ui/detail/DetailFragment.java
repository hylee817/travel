package com.techton.travel.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.techton.travel.R;
import com.techton.travel.ui.result.ResultViewModel;

public class DetailFragment extends Fragment{
    private DetailViewModel detailViewModel;
    LinearLayout resultBusan1;
    ImageButton heartButton;
    Boolean filled;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detailViewModel =
                ViewModelProviders.of(this).get(DetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_detail, container, false);

        filled = false;

        heartButton = root.findViewById(R.id.heart_button);
        heartButton.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                if (filled==false) {
                    heartButton.setImageResource(R.drawable.detail_heart_filled);
                    heartButton.setAlpha((float)1.0);
                }
                else{
                    heartButton.setImageResource(R.drawable.detail_heart_empty);
                    heartButton.setAlpha((float)0.7);
                }
                filled = !filled;
            }
        });

        return root;
    }
}