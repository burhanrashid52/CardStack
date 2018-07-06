package com.burhanrashid52.cards.swipeLayout

import android.graphics.Canvas
import android.support.v7.widget.RecyclerView

import com.burhanrashid52.cards.swipeLayout.touchelper.ItemTouchHelper


open class StackTouchHelperCallback(private val onItemSwiped: OnItemSwiped) : ItemTouchHelper.Callback() {

    private val allowedSwipeDirectionsMovementFlags: Int
        get() = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT

    private val allowedDirectionsMovementFlags: Int
        get() = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.UP or ItemTouchHelper.DOWN

    open fun getAllowedSwipeDirectionsMovementFlags(viewHolder: RecyclerView.ViewHolder): Int {
        return allowedSwipeDirectionsMovementFlags
    }

    fun getAllowedDirectionsMovementFlags(holder: RecyclerView.ViewHolder): Int {
        return allowedDirectionsMovementFlags
    }

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder): Int {
        return ItemTouchHelper.Callback.makeMovementFlags(0,
                if (viewHolder.adapterPosition != 0) 0 else getAllowedDirectionsMovementFlags(viewHolder))
    }

    fun getThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return viewHolder.itemView.width * 0.9f
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                        target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val allowedSwipeDirections = getAllowedSwipeDirectionsMovementFlags(viewHolder)
        if (direction == ItemTouchHelper.LEFT && allowedSwipeDirections and ItemTouchHelper.LEFT != 0) {
            onItemSwiped.onItemSwipedLeft()
            onItemSwiped.onItemSwiped()
        } else if (direction == ItemTouchHelper.RIGHT && allowedSwipeDirections and ItemTouchHelper.RIGHT != 0) {
            onItemSwiped.onItemSwipedRight()
            onItemSwiped.onItemSwiped()
        } else if (direction == ItemTouchHelper.UP && allowedSwipeDirections and ItemTouchHelper.UP != 0) {
            onItemSwiped.onItemSwipedUp()
            onItemSwiped.onItemSwiped()
        } else if (direction == ItemTouchHelper.DOWN && allowedSwipeDirections and ItemTouchHelper.DOWN != 0) {
            onItemSwiped.onItemSwipedDown()
            onItemSwiped.onItemSwiped()
        }
        viewHolder.itemView.invalidate()
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.5f
    }

    override fun getAnimationDuration(recyclerView: RecyclerView, animationType: Int,
                                      animateDx: Float, animateDy: Float): Long {
        return (recyclerView.layoutManager as StackLayoutManager).animationDuration
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView,
                             viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int,
                             isCurrentlyActive: Boolean) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        val swipValue = Math.sqrt((dX * dX + dY * dY).toDouble())
        var fraction = swipValue / getThreshold(viewHolder)
        fraction = Math.min(1.0, fraction)

        if (viewHolder is OnItemSwipePercentageListener) {
            (viewHolder as OnItemSwipePercentageListener).onItemSwipePercentage(
                    Math.max(-1f, Math.min(1f, dX / recyclerView.measuredWidth)).toDouble())
        }

        val swipeableLayoutManager = recyclerView.layoutManager as StackLayoutManager

        val childCount = recyclerView.childCount
        if (viewHolder.adapterPosition == 0) {
            viewHolder.itemView.rotation = swipeableLayoutManager.angle * (dX / recyclerView.measuredWidth)
            viewHolder.itemView.scaleX = 1f
            viewHolder.itemView.scaleY = 1f
        }

        for (i in 0 until childCount) {
            val child = recyclerView.getChildAt(i)
            val level = childCount - i - 1

            if (level > 0) {
                val scale = Math.max(0f, Math.min(1f,
                        (1 - swipeableLayoutManager.scaleGap * level + fraction * swipeableLayoutManager.scaleGap).toFloat()))
                child.scaleX = scale

                if (level < swipeableLayoutManager.maxShowCount - 1) {
                    child.scaleY = scale
                    child.translationY = Math.max(0f, (swipeableLayoutManager.transYGap * level - fraction * swipeableLayoutManager.transYGap).toFloat())
                }
            }
        }
    }

    override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.rotation = 0f
        viewHolder.itemView.scaleX = 1f
        viewHolder.itemView.scaleY = 1f
    }
}
