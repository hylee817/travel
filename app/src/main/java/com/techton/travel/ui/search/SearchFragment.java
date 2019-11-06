package com.techton.travel.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.techton.travel.R;
import com.techton.travel.ui.home.HomeFragment;
import com.techton.travel.ui.home.HomeViewModel;

public class SearchFragment  extends Fragment {

    private SearchViewModel searchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        ImageButton searchButton = root.findViewById(R.id.search_back_btn);
        searchButton.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast toast = Toast.makeText(getActivity(), "temp", Toast.LENGTH_SHORT);
                toast.show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
            }
        });

        return root;
    }
}
