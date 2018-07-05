package com.burhanrashid52.swipe.home

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.burhanrashid52.swipe.R
import com.burhanrashid52.swipe.swipeLayout.OnItemSwiped
import com.burhanrashid52.swipe.swipeLayout.StackLayoutManager
import com.burhanrashid52.swipe.swipeLayout.StackTouchHelperCallback
import com.burhanrashid52.swipe.swipeLayout.touchelper.ItemTouchHelper
import ja.burhanrashid52.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSwipe.itemAnimator = DefaultItemAnimator()
        val numbers = mutableListOf("1", "2", "3", "4", "5", "6", "7")
        val cardAdapter = CardsAdapter()
        rvSwipe.adapter = cardAdapter
        cardAdapter.list = numbers

        val stackTouchHelperCallback: StackTouchHelperCallback = object : StackTouchHelperCallback(object : OnItemSwiped {
            override fun onItemSwiped() {
                cardAdapter.removeTopItem()
            }

            override fun onItemSwipedLeft() {
                Log.e("SWIPE", "LEFT")
            }

            override fun onItemSwipedRight() {
                Log.e("SWIPE", "RIGHT")
            }

            override fun onItemSwipedUp() {
                Log.e("SWIPE", "UP")
            }

            override fun onItemSwipedDown() {
                Log.e("SWIPE", "DOWN")
            }
        }) {
            override fun getAllowedSwipeDirectionsMovementFlags(viewHolder: RecyclerView.ViewHolder): Int {
                return ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            }
        }
        val itemTouchHelper = ItemTouchHelper(stackTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(rvSwipe)
        rvSwipe.layoutManager = StackLayoutManager().setAngle(10)
                .setAnimationDuratuion(450)
                .setMaxShowCount(3)
                .setScaleGap(0.1f)
                .setTransYGap(0)
        rvSwipe.adapter = cardAdapter
    }
}
