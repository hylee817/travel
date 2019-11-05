package com.techton.travel.ui.cal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.techton.travel.R;

public class CalFragment extends Fragment {

    private CalViewModel calViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calViewModel =
                ViewModelProviders.of(this).get(CalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cal, container, false);

        return root;
    }
}