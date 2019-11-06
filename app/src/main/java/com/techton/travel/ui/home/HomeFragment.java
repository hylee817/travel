package com.techton.travel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;

import com.techton.travel.Main2Activity;
import com.techton.travel.R;
import com.techton.travel.ui.search.SearchFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton searchButton = root.findViewById(R.id.home_search_btn);
        searchButton.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast toast = Toast.makeText(getActivity(), "temp", Toast.LENGTH_SHORT);
                toast.show();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,new SearchFragment()).addToBackStack(null).commit();
            }
        });

        return root;
    }
}