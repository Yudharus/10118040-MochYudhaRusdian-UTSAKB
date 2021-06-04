package com.yudharus.myselfapps.adapter;

//Tanggal pengerjaan   : 27/5/2021
//NIM                  : 10118040
//NAMA                 :Moch Yudha Rusdian

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

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



public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsView>{


    List<Integer> imageList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    Activity activity;

    public FriendsAdapter(Activity activity, List<String> nameList, List<Integer> imageList) {
        this.activity = activity;
        this.imageList = imageList;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public FriendsAdapter.FriendsView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friend_card,viewGroup,false);

        return new FriendsView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsAdapter.FriendsView holder, int position) {
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(16));
//        Glide
//                .with(activity)
//                .load(imageList.get(position))
//                .override(500,500)
//                .apply(requestOptions)
//                .into(holder.imageView);
        //imageview.imageView.setImageResource((Integer) imageList.get(position));

        holder.imageView.setImageResource((Integer) imageList.get(position));
        holder.textView.setText(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }



    public class FriendsView extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        public FriendsView(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageItem);
            textView = (TextView)itemView.findViewById(R.id.textItem);
        }

        public ImageView getImageView(){
            return imageView;
        }

        public TextView getTextView(){
            return textView;
        }
    }

}