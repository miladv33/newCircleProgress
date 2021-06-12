package com.example.queue

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat

class CircleCustomView(context: Context,attributeSet: AttributeSet,viewId: Int):ConstraintLayout(context,attributeSet) {
    init {
        id = viewId
        var view = LayoutInflater.from(context).inflate(R.layout.circle, this, true)
        ViewCompat.setTranslationZ(this,1F)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        layoutParams.height = MATCH_PARENT
        layoutParams.width = MATCH_PARENT
    }
}