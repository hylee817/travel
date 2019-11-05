package com.techton.travel.ui.cal;

import android.os.Bundle;
import android.util.Log;
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

import net.daum.mf.map.api.MapView;

import java.util.Map;

public class CalFragment extends Fragment {

    private CalViewModel calViewModel;
    private MapView mapView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calViewModel =
                ViewModelProviders.of(this).get(CalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cal, container, false);
        //error
        mapView = new MapView(getActivity());
        ViewGroup mapViewContainer =  (ViewGroup) root.findViewById(R.id.mapview_container);
        mapViewContainer.addView(mapView);
        Log.d("cal","addview 실행 후");

        return root;
    }


}