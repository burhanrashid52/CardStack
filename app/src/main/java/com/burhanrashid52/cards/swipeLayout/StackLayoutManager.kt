package com.burhanrashid52.cards.swipeLayout

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class StackLayoutManager(internal var maxShowCount: Int = 3,
                         internal var scaleGap: Float = 0.1f,
                         internal var transYGap: Int = 0,
                         internal var angle: Int = 10,
                         internal var animationDuration: Long = 450) : RecyclerView.LayoutManager() {


    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        detachAndScrapAttachedViews(recycler)
        val itemCount = itemCount
        if (itemCount < 1) {
            return
        }

        var startPosition = Math.min(maxShowCount, itemCount) - 1
        startPosition = if (startPosition > 0) startPosition else 0

        for (position in startPosition downTo 0) {
            val view = recycler.getViewForPosition(position)
            addView(view)
            measureChildWithMargins(view, 0, 0)
            val widthSpace = width - getDecoratedMeasuredWidth(view)
            val heightSpace = height - getDecoratedMeasuredHeight(view)
            layoutDecorated(view, widthSpace / 2, heightSpace / 2,
                    widthSpace / 2 + getDecoratedMeasuredWidth(view),
                    heightSpace / 2 + getDecoratedMeasuredHeight(view))
            if (position > 0) {
                view.scaleX = validateScale(1 - scaleGap * position)
                if (position < maxShowCount - 1) {
                    view.translationY = validateScale((transYGap * position).toFloat())
                    view.scaleY = validateScale(1 - scaleGap * position)
                } else {
                    view.translationY = validateTranslation((transYGap * (position - 1)).toFloat())
                    view.scaleY = validateScale(1 - scaleGap * (position - 1))
                }
            }
        }
    }

    private fun validateTranslation(value: Float): Float {
        return Math.max(0f, value)
    }

    private fun validateScale(value: Float): Float {
        return Math.max(0f, Math.min(1f, value))
    }

    fun getScaleGap(): Float {
        return scaleGap
    }

    fun getMaxShowCount(): Int {
        return maxShowCount
    }

    fun getTransYGap(): Int {
        return transYGap
    }

    fun getAngle(): Int {
        return angle
    }

    fun getAnimationDuratuion(): Long {
        return animationDuration
    }

    /**
     * max views rendered under recycler view
     *
     * @param maxShowCount default value 3
     */
    fun setMaxShowCount(maxShowCount: Int): StackLayoutManager {
        this.maxShowCount = Math.max(maxShowCount, 1)
        return this
    }

    /**
     * Percentage of scaling views behind top view
     *
     * @param scaleGap min value = 0 max value = 1 default value = 0.1
     */
    fun setScaleGap(scaleGap: Float): StackLayoutManager {
        this.scaleGap = Math.min(Math.max(0f, scaleGap), 1f)
        return this
    }

    /**
     * Represents value in used to translate center of views behind top view  and create nice card
     * stack effect
     *
     * @param transYGap default value 0
     */
    fun setTransYGap(transYGap: Int): StackLayoutManager {
        this.transYGap = transYGap
        return this
    }

    /**
     * Angle in degres used for rotation of top view while swiping left or right
     */
    fun setAngle(angle: Int): StackLayoutManager {
        this.angle = angle
        return this
    }

    /**
     * Animation duration after swiping view
     */
    fun setAnimationDuratuion(animationDuratuion: Long): StackLayoutManager {
        this.animationDuration = Math.max(1, animationDuratuion)
        return this
    }
}
