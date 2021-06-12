package com.example.queue

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat

class LineCustomView(context: Context, attributeSet: AttributeSet,viewId:Int) :
    ConstraintLayout(context, attributeSet) {
    private var view = LayoutInflater.from(context).inflate(R.layout.line, this, true)

    init {
        id = viewId
        ViewCompat.setTranslationZ(this,0F)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        layoutParams.width =0
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
    }
}