package com.yudharus.myselfapps.fragment;

// Tanggal pengerjaan   : 3/6/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yudharus.myselfapps.R;


public class ProfileFragment extends Fragment {

    RelativeLayout wa, ig, email;
    View maps;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        wa = view.findViewById(R.id.no_wa);
        ig = view.findViewById(R.id.akun_ig);
        email = view.findViewById(R.id.no_ig);
        maps = view.findViewById(R.id.google_maps);
        wa.setOnClickListener(this::OnWaClicked);
        ig.setOnClickListener(this::OnIGClicked);
        email.setOnClickListener(this::OnEmailClicked);
        maps.setOnClickListener(this::OnMapsClicked);
        return view;
    }


    public void OnWaClicked(View view){
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:081214720940"));
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(intentCall);
        }
    }

    public void OnIGClicked(View view){
        OpenURL("https://www.instagram.com/yudharuss/");
    }

    public void OnEmailClicked(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yudharus007@gmail.com"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{""});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(intent, null));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }

    public void OnMapsClicked(View view){
        OpenURL("https://goo.gl/maps/JraiqdaRWaZJHBm18");
    }

    public void OpenURL(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}