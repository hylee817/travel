package com.techton.travel.ui.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.techton.travel.R;
import com.techton.travel.ui.detail.DetailFragment;
import com.techton.travel.ui.home.HomeViewModel;
import com.techton.travel.ui.nav.NavViewModel;

public class ResultFragment extends Fragment{
    private ResultViewModel resultViewModel;
    LinearLayout resultBusan1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resultViewModel =
                ViewModelProviders.of(this).get(ResultViewModel.class);
        View root = inflater.inflate(R.layout.fragment_result, container, false);

        resultBusan1 = root.findViewById(R.id.result_busan_1);
        resultBusan1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.container);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,new DetailFragment()).addToBackStack(null).commit();

            }
        });

        return root;
    }
}