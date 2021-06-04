package com.yudharus.myselfapps.fragment;

// Tanggal pengerjaan   : 31/5/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yudharus.myselfapps.R;
import com.yudharus.myselfapps.adapter.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView recycler;

    GalleryAdapter adapter;

    List<Integer> imageList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.yudha1);
        imageList.add(R.drawable.yudha2);
        imageList.add(R.drawable.yudha3);
        imageList.add(R.drawable.yudha4);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_home);
        adapter = new GalleryAdapter(getActivity(), imageList);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        return view;
    }
}