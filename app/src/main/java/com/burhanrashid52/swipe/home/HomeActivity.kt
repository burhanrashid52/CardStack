package com.burhanrashid52.swipe.home

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.Toast
import com.burhanrashid52.swipe.R
import com.burhanrashid52.swipe.base.BaseActivity
import com.burhanrashid52.swipe.swipeLayout.CardItemTouchHelperCallback
import com.burhanrashid52.swipe.swipeLayout.CardLayoutManager
import com.burhanrashid52.swipe.swipeLayout.OnSwipeListener
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSwipe.itemAnimator = DefaultItemAnimator()
        val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7)
        val cardAdapter = CardsAdapter()
        rvSwipe.adapter = cardAdapter
        cardAdapter.list = numbers
        val cardCallback = CardItemTouchHelperCallback(rvSwipe.adapter, numbers)
        cardCallback.setOnSwipedListener(object : OnSwipeListener<Int> {

            override fun onSwiping(viewHolder: RecyclerView.ViewHolder, ratio: Float, direction: Int) {
                /* val myHolder = viewHolder as CardsAdapter.MyViewHolder
                 viewHolder.itemView.alpha = 1 - Math.abs(ratio) * 0.2f
                 if (direction == CardConfig.SWIPING_LEFT) {
                     myHolder.dislikeImageView.setAlpha(Math.abs(ratio))
                 } else if (direction == CardConfig.SWIPING_RIGHT) {
                     myHolder.likeImageView.setAlpha(Math.abs(ratio))
                 } else {
                     myHolder.dislikeImageView.setAlpha(0f)
                     myHolder.likeImageView.setAlpha(0f)
                 }*/
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, o: Int, direction: Int) {
                /*         val myHolder = viewHolder as MyAdapter.MyViewHolder
                         viewHolder.itemView.alpha = 1f
                         myHolder.dislikeImageView.setAlpha(0f)
                         myHolder.likeImageView.setAlpha(0f)
                         Toast.makeText(this@HomeActivity, if (direction == CardConfig.SWIPED_LEFT) "swiped left" else "swiped right", Toast.LENGTH_SHORT).show()*/
            }

            override fun onSwipedClear() {
                Toast.makeText(this@HomeActivity, "data clear", Toast.LENGTH_SHORT).show()
                rvSwipe.postDelayed({
                    //initData()
                    rvSwipe.adapter.notifyDataSetChanged()
                }, 3000L)
            }

        })
        val touchHelper = ItemTouchHelper(cardCallback)
        val cardLayoutManager = CardLayoutManager(rvSwipe, touchHelper)
        rvSwipe.layoutManager = cardLayoutManager
        touchHelper.attachToRecyclerView(rvSwipe)
    }
}
