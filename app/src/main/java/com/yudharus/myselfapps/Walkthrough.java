package com.yudharus.myselfapps;
// Tanggal pengerjaan   : 4/6/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yudharus.myselfapps.onboarding.OnBoardingAdapter;
import com.yudharus.myselfapps.onboarding.OnBoardingItem;

import java.util.ArrayList;
import java.util.List;

public class Walkthrough extends AppCompatActivity {
    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout LayoutOnBoardingIndicators;
    private Button OnBoardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        LayoutOnBoardingIndicators = findViewById(R.id.vp1_layoutOnBoardingIndicator);
        OnBoardingAction = findViewById(R.id.vp1_buttonOnBoard);

        setupOnBoardingItems();

        ViewPager2 onBoardingViewPager = findViewById(R.id.vp1_onboardingvp);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setupOnBoardingIndicators();
        setCurrentOnBoardingIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        OnBoardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()){
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }
        });
    }
    private void setupOnBoardingItems(){
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();
        OnBoardingItem item1 = new OnBoardingItem();
        item1.setTittle("Hello there!");
        item1.setDescription("DIAPLIKASI INI KALIAN BISA KEPOIN TENTANG DATA DIRI ATAU INFORMASI LAINNYA YANGKAMU BELUM TAU DARIKU!");
        item1.setImage(R.drawable.walk1);

        OnBoardingItem item2 = new OnBoardingItem();
        item2.setTittle("MEMENUHI TUGAS UTS");
        item2.setDescription("APLIKASI DIBUAT BERTUJUAN UNTUK MEMENUHI TUGAS UTS MYSELF APPS");
        item2.setImage(R.drawable.walk2);

        OnBoardingItem item3 = new OnBoardingItem();
        item3.setTittle("YUK LANGSUNG KEPOIN AJA ?");
        item3.setDescription("JANGAN LAMA LAMA BUANG WAKTU , MENDING LANGSUNG KEPOIN AJA");
        item3.setImage(R.drawable.walk3);

        onBoardingItems.add(item1);
        onBoardingItems.add(item2);
        onBoardingItems.add(item3);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }
    private void setupOnBoardingIndicators(){
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0,8,0);
        for (int i = 0 ; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.walkthrough_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            LayoutOnBoardingIndicators.addView(indicators[i]);

        }
    }

    private void setCurrentOnBoardingIndicator(int index){
        int childCount = LayoutOnBoardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView)LayoutOnBoardingIndicators.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.walkthrough_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.walkthrough_inactive)
                );
            }
        }
        if (index == onBoardingAdapter.getItemCount() - 1 ){
            OnBoardingAction.setText("Start");

        }else {
            OnBoardingAction.setText("Next");
        }


    }
}