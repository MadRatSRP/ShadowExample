package com.madrat.shadowexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.madrat.shadowexample.databinding.ImageLayoutBinding;

public class RoundLinerLayoutNormal extends LinearLayout {
    ImageLayoutBinding binding;
    
    public RoundLinerLayoutNormal(Context context) {
        super(context);
        doOnInit();
    }
    
    public RoundLinerLayoutNormal(Context context,
                                  @Nullable AttributeSet attrs) {
        super(context, attrs);
        doOnInit();
    }
    
    public RoundLinerLayoutNormal(Context context,
                                  @Nullable AttributeSet attrs,
                                  int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        doOnInit();
    }
    
    void doOnInit() {
        binding = ImageLayoutBinding.inflate(LayoutInflater.from(getContext()));
        initBackground();
    }
    
    private void initBackground() {
        setOrientation(VERTICAL);
        /*setBackground(
            ViewUtils.generateBackgroundWithShadow(
                binding.getRoot(),
                R.color.white,
                R.dimen.radius_corner,
                android.R.color.darker_gray,
                R.dimen.elevation,
                Gravity.BOTTOM
            )
        );*/
        //binding.rootImage.setImageResource(R.drawable.ic_baseline_favorite_24);
        binding.rootImage.setBackgroundColor(R.color.purple_500);
    }
}
