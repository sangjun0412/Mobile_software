package com.course.final_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements  OnMapReadyCallback{

    private GoogleMap mMap;
    private double wedo, lon;
    private String dept;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map_activity);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // 마커를 동국대로 위치시키고 카메라를 이동시킴
        LatLng dongguk = new LatLng(37.558058787929134, 126.99840306484138);
        // 마커에 대한 옵션 설정
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(dongguk);
        markerOptions.title("고객 센터");
        markerOptions.snippet("찾는 곳");
        mMap.addMarker(markerOptions);
        // 줌 기능 활성화
        mMap.getUiSettings().setZoomGesturesEnabled(true); //줌 기능 활성화
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dongguk,17));
    }
}