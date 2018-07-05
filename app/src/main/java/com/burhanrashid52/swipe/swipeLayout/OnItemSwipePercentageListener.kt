package com.burhanrashid52.swipe.swipeLayout

interface OnItemSwipePercentageListener {

    /**
     * percentage vale from -1 to 1
     * represents percentage of card swiped -1 fully swiped to left 0 starting position and 1 fully
     * swiped to right
     */
    fun onItemSwipePercentage(percentage: Double)
}
