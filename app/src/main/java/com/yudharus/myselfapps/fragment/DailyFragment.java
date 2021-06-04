package com.yudharus.myselfapps.fragment;

// Tanggal pengerjaan   : 31/5/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yudharus.myselfapps.R;
import com.yudharus.myselfapps.adapter.FriendsAdapter;

import java.util.ArrayList;
import java.util.List;

public class DailyFragment extends Fragment {


    RecyclerView recycler;

    FriendsAdapter adapter;

    List<Integer> imageList;
    List<String> nameList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.friend1);
        imageList.add(R.drawable.friend2);
        imageList.add(R.drawable.friend3);
        imageList.add(R.drawable.friend4);
        imageList.add(R.drawable.friend5);
        imageList.add(R.drawable.friend6);

        nameList = new ArrayList<String>();
        nameList.add("HARIS");
        nameList.add("MEIDY");
        nameList.add("RADIFA");
        nameList.add("MILANDA");
        nameList.add("FARHAN");
        nameList.add("ALYA");

        recycler = (RecyclerView) view.findViewById(R.id.recycler_friends);
        adapter = new FriendsAdapter(getActivity(), nameList, imageList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        return view;
    }
}