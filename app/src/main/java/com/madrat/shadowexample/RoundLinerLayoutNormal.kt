package com.madrat.shadowexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class RoundLinerLayoutNormal extends LinearLayout {
    public RoundLinerLayoutNormal(Context context) {
        super(context);
        initBackground();
    }
    
    public RoundLinerLayoutNormal(Context context,
                                  @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBackground();
    }
    
    public RoundLinerLayoutNormal(Context context,
                                  @Nullable AttributeSet attrs,
                                  int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBackground();
    }
    
    private void initBackground() {
        setBackground(
            ViewUtils.generateBackgroundWithShadow(
                this,
                R.color.white,
                R.dimen.radius_corner,
                android.R.color.darker_gray,
                R.dimen.elevation,
                Gravity.BOTTOM)
        );
    }
}
