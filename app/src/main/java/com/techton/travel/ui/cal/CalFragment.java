package com.techton.travel.ui.cal;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.geometry.LatLngBounds;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.PolygonOverlay;
import com.naver.maps.map.overlay.PolylineOverlay;
import com.naver.maps.map.util.MarkerIcons;
import com.techton.travel.R;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static com.naver.maps.map.overlay.PolylineOverlay.LineCap.Round;

public class CalFragment extends Fragment implements OnMapReadyCallback {   //api를 쓰기위한 onMapReadyCallBack구현

    private CalViewModel calViewModel;

    String name1 = "고지대그린테마공원";
    String name2 = "동백섬 해안산책로";
    String name3 = "태종대";
    String address1 = "부산 동구 수정동 777-1";
    String address2 = "부산광역시 해운대구 우1동 707";
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
        adapter = new CalAdapter(items);  //생성자로 어댑터에 리스트 부착
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        CalItemTouchHelperCallback callback = new CalItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
        //구현한 callBack을 RecyclerView에 붙착.

        recyclerView.setAdapter(adapter);
        adapter.passTouchHelper(touchHelper);   //인스턴스를 adapter로 전달


        CalItem item1 = new CalItem("1",name1,address1);
        CalItem item2 = new CalItem("2",name2, address2);
        CalItem item3 = new CalItem("3",name3, address3);
        //아이템 객체 생성
        adapter.addItem(item1);
        adapter.addItem(item2);
        adapter.addItem(item3);
        recyclerView.getAdapter().notifyDataSetChanged();;
        //아이템을 리스트에 추가




        /////////////////네이버 지도 API사용을 위한 코드///////////////////
        FragmentManager fm = getChildFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

        return root;
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        //맵을 생성할 준비가 되었을 때 가장 먼저 호출되는 오버라이드 메소드이다. 이 메소드 안에서 지도의 속성을 초기화할 수 있다.
        // ...

        //마커 표시
        Marker marker1 = new Marker();
        Marker marker2 = new Marker();
        Marker marker3 = new Marker();
        marker1.setPosition(new LatLng(35.1322508,129.038462));
        marker2.setPosition(new LatLng(35.1535821,129.153062));
        marker3.setPosition(new LatLng(35.0554585,129.087973));
        marker1.setIcon(MarkerIcons.BLACK);marker1.setIconTintColor(0xFFA493FF);
        marker2.setIcon(MarkerIcons.BLACK);marker2.setIconTintColor(0xFFA493FF);
        marker3.setIcon(MarkerIcons.BLACK);marker3.setIconTintColor(0xFFA493FF);
        marker1.setMap(naverMap); marker2.setMap(naverMap); marker3.setMap(naverMap);

        //폴리곤 표시
        PolylineOverlay polyline = new PolylineOverlay();
        polyline.setCoords(Arrays.asList(
                new LatLng(35.1322508,129.038462),
                new LatLng(35.1535821,129.153062),
                new LatLng(35.0554585,129.087973)
        ));
        polyline.setColor(0xFFA493FF);
        polyline.setWidth(15);
        polyline.setCapType(PolylineOverlay.LineCap.Round);
        polyline.setMap(naverMap);

        //지도 범위 지정
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(new LatLng(35.1322508,129.038462))
                .include(new LatLng(35.1535821,129.153062))
                .include(new LatLng(35.0554585,129.087973))
                .build();
        naverMap.setExtent(bounds);
    }


}