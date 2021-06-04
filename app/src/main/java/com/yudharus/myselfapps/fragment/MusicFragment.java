package com.yudharus.myselfapps.fragment;

// Tanggal pengerjaan   : 1/6/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.yudharus.myselfapps.R;
import com.yudharus.myselfapps.adapter.FriendsAdapter;
import com.yudharus.myselfapps.adapter.MusicAdapter;
import com.yudharus.myselfapps.adapter.VideoData;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {

    RecyclerView recycler;
    VideoView videoView;
    MusicAdapter adapter;

    List<VideoData> videoList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        videoView = view.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

        videoList = new ArrayList<VideoData>();
        videoList.add(new VideoData("Video1", "android.resource://"+getContext().getPackageName()+"/"+R.raw.video1));
        videoList.add(new VideoData("Video2", "android.resource://"+getContext().getPackageName()+"/"+R.raw.video2));
        videoList.add(new VideoData("Video3", "android.resource://"+getContext().getPackageName()+"/"+R.raw.video3));
        videoList.add(new VideoData("Video4", "android.resource://"+getContext().getPackageName()+"/"+R.raw.video4));
        videoList.add(new VideoData("Video5", "android.resource://"+getContext().getPackageName()+"/"+R.raw.video5));

        videoView.setVideoURI(Uri.parse(videoList.get(0).uri));

        recycler = (RecyclerView) view.findViewById(R.id.recycler_titles);
        adapter = new MusicAdapter(getActivity(), videoView, videoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        return view;
    }
}