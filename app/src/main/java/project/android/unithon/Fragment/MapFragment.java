package project.android.unithon.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.android.unithon.Service.LocationListener;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import project.android.unithon.R;

/**
 * Created by qkrqh on 2017-07-29.
 */

public class MapFragment extends Fragment{

    GoogleMap googleMap;
    static View view;

    LocationListener locationListener;
    MarkerOptions markerOptions;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            view = inflater.inflate(R.layout.fragment_map, container, false);}
        catch (InflateException e){}

        locationListener = new LocationListener(getActivity());

        com.google.android.gms.maps.MapFragment mapFragment = (com.google.android.gms.maps.MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(mapReadyCallback);

        return view;
    }

    OnMapReadyCallback mapReadyCallback  = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap map) {

            googleMap = map;

            /*
            UiSettings settings = googleMap.getUiSettings(); //todo 줌버튼 아직 미정
            settings.setZoomControlsEnabled(true);
             */

            LatLng baseLatlng = new LatLng(locationListener.getLocation().latitude, locationListener.getLocation().longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(baseLatlng, 17));
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(view != null){
            ViewGroup parent = (ViewGroup)view.getParent();
            if(parent!=null){
                parent.removeView(view);
            }
        }
    }

}
