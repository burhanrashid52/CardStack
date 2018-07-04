package com.burhanrashid52.swipe.swipeLayout

import android.support.v7.widget.RecyclerView

interface OnSwipeListener<T> {

    /**
     * Callback when the card is still sliding
     *
     * @param viewHolder The sliding view of the watchHolder
     * @param ratio      ratio of sliding progress
     * @param direction  The direction in which the card slides, CardConfig.SWIPING_LEFT is to the left, and CardConfig.SWIPING_RIGHT is to the right.
     * CardConfig.SWIPING_NONE is not left or right
     */
    fun onSwiping(viewHolder: RecyclerView.ViewHolder, ratio: Float, direction: Int)

    /**
     * Callback when the card slides out completely
     *
     * @param viewHolder The slide view's viewHolder
     * @param t          The data of the slide out card
     * @param direction  The direction in which the card slides out, CardConfig.SWIPED_LEFT slides out to the left; CardConfig.SWIPED_RIGHT slides to the right
     */
    fun onSwiped(viewHolder: RecyclerView.ViewHolder, t: T, direction: Int)

    /**
     * Callbacks when all cards are slipped out
     */
    fun onSwipedClear()

}