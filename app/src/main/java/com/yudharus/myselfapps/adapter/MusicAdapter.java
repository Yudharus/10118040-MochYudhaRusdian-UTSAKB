package com.yudharus.myselfapps.adapter;

// Tanggal pengerjaan   : 28/5/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.yudharus.myselfapps.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicView>{


    List<VideoData> videoData = new ArrayList<>();
    VideoView videoView;
    Activity activity;

    public MusicAdapter(Activity activity, VideoView videoView,List<VideoData> videoData) {
        this.activity = activity;
        this.videoData = videoData;
        this.videoView = videoView;
    }

    @NonNull
    @Override
    public MusicAdapter.MusicView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.music_card, viewGroup,false);

        return new MusicView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MusicView holder, int position) {
        holder.judulView.setText(videoData.get(position).title);
        holder.judulView.setOnClickListener(v -> {
            videoView.setVideoURI(Uri.parse(videoData.get(position).uri));
            videoView.start();
        });
    }

    @Override
    public int getItemCount() {
        return videoData.size();
    }


    public class MusicView extends RecyclerView.ViewHolder{
        TextView judulView;
        public MusicView(@NonNull View itemView) {
            super(itemView);
            judulView = (TextView)itemView.findViewById(R.id.judul);
        }

        public TextView getJudulView(){
            return getJudulView();
        }
    }
}