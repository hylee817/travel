package com.techton.travel.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.techton.travel.R;
import com.techton.travel.ui.result.ResultViewModel;

public class DetailFragment extends Fragment{
    private DetailViewModel detailViewModel;
    LinearLayout resultBusan1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detailViewModel =
                ViewModelProviders.of(this).get(DetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_detail, container, false);

        return root;
    }
}