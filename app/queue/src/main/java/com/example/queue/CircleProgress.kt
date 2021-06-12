package com.example.queue

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import java.util.*

class CircleProgress(context: Context, var attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {
    private var circleIds = ArrayList<Int>()
    private var lineId = generateViewId()
    private var customAttribute =
        context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgress)
    private var circleNumber = 3

    init {
        with(customAttribute) {
            circleNumber = getInt(R.styleable.CircleProgress_circleNumber, 3)
        }
        addCircles()
        createChine()
        addLine()
    }

    private fun addCircles() {
        for (i in 0..circleNumber) {
            val viewId = generateViewId()
            addView(CircleCustomView(context, attributeSet, viewId))
            circleIds.add(viewId)
        }

    }

    private fun addLine() {
        if (circleIds.isEmpty()) return
        val constraintSet = ConstraintSet()
        val lineCustomView = LineCustomView(context, attributeSet, lineId)
        addView(lineCustomView)
        constraintSet.clone(this)
        constraintSet.connect(lineId, ConstraintSet.TOP, circleIds.first(), ConstraintSet.TOP)
        constraintSet.connect(lineId, ConstraintSet.BOTTOM, circleIds.first(), ConstraintSet.BOTTOM)
        constraintSet.applyTo(this)

    }

    private fun createChine() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)
        for (i in 1..circleNumber) {
            constraintSet.createHorizontalChainRtl(
                ConstraintSet.PARENT_ID, ConstraintSet.START,
                ConstraintSet.PARENT_ID, ConstraintSet.END, circleIds.toIntArray(), null,
                ConstraintSet.CHAIN_SPREAD_INSIDE
            )
        }
        constraintSet.applyTo(this)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
    }

}