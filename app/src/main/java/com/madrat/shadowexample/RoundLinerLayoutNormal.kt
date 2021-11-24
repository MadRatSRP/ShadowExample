package com.madrat.shadowexample

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import com.madrat.shadowexample.ViewUtils.generateBackgroundWithShadow

class RoundLinerLayoutNormal : LinearLayout {
    constructor(context: Context?) : super(context) {
        initBackground()
    }
    
    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        initBackground()
    }
    
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        initBackground()
    }
    
    private fun initBackground() {
        background = generateBackgroundWithShadow(
            this.context,
            R.color.white,
            R.dimen.radius_corner,
            android.R.color.darker_gray,
            R.dimen.elevation,
            Gravity.BOTTOM
        )
    }
}