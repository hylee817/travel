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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.overlay.Marker;
import com.techton.travel.R;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.Map;

public class CalFragment extends Fragment {

    private CalViewModel calViewModel;
    NaverMap naverMap;

    String name1 = "고지대그린테마공원";
    String name2 = "동백공원";
    String name3 = "태종대";
    String address1 = "부산 동구 수정동 777-1";
    String address2 = "부산 해운대구 우동";
    String address3 = "부산 영도구 동삼동 산 29-1";

    RecyclerView recyclerView;
    CalAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<CalItem> items;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calViewModel =
                ViewModelProviders.of(this).get(CalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cal, container, false);

        items = new ArrayList<CalItem>();
        recyclerView = root.findViewById(R.id.recyclerView);
        adapter = new CalAdapter(items);  //생성자로
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        CalItem item1 = new CalItem("1",name1,address1);
        CalItem item2 = new CalItem("2",name2, address2);
        CalItem item3 = new CalItem("3",name3, address3);
        //아이템 객체 생성
        adapter.addItem(item1);
        adapter.addItem(item2);
        adapter.addItem(item3);
        recyclerView.getAdapter().notifyDataSetChanged();;
        //리스트에 추가

        //naverMap = root.findFragmentById(R.id.map);
        Marker marker = new Marker();
        marker.setPosition(new LatLng(129.038462,35.1322508));
        //marker.setPosition(new LatLng());
        marker.setPosition(new LatLng(129.087973,35.0554585));
        marker.setMap(naverMap);
        //지도에 마커 표시

        return root;
    }


}