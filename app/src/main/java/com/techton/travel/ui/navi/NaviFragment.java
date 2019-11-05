package com.techton.travel.ui.navi;

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

public class NaviFragment extends Fragment {

    private NaviViewModel naviViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        naviViewModel =
                ViewModelProviders.of(this).get(NaviViewModel.class);
        View root = inflater.inflate(R.layout.fragment_navi, container, false);

        //이거 없어도 될 것 같은데
        final TextView textView = root.findViewById(R.id.text_navi);
        naviViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}