package com.burhanrashid52.cards.swipeLayout.touchelper

import android.graphics.Canvas
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchUIUtil
import android.view.View

/**
 * Package private class to keep implementations. Putting them inside ItemTouchUIUtil makes them
 * public API, which is not desired in this case.
 */
internal class ItemTouchUIUtilImpl {
    internal class Api21Impl : BaseImpl() {
        override fun onDraw(c: Canvas, recyclerView: RecyclerView, view: View,
                            dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
            if (isCurrentlyActive) {
                var originalElevation: Any? = view.getTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation)
                if (originalElevation == null) {
                    originalElevation = ViewCompat.getElevation(view)
                    val newElevation = 1f + findMaxElevation(recyclerView, view)
                    ViewCompat.setElevation(view, newElevation)
                    view.setTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation, originalElevation)
                }
            }
            super.onDraw(c, recyclerView, view, dX, dY, actionState, isCurrentlyActive)
        }

        private fun findMaxElevation(recyclerView: RecyclerView, itemView: View): Float {
            val childCount = recyclerView.childCount
            var max = 0f
            for (i in 0 until childCount) {
                val child = recyclerView.getChildAt(i)
                if (child === itemView) {
                    continue
                }
                val elevation = ViewCompat.getElevation(child)
                if (elevation > max) {
                    max = elevation
                }
            }
            return max
        }

        override fun clearView(view: View) {
            val tag = view.getTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation)
            if (tag != null && tag is Float) {
                ViewCompat.setElevation(view, tag)
            }
            view.setTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation, null)
            super.clearView(view)
        }
    }

    internal open class BaseImpl : ItemTouchUIUtil {

        override fun clearView(view: View) {
            view.translationX = 0f
            view.translationY = 0f
        }

        override fun onSelected(view: View) {

        }

        override fun onDraw(c: Canvas, recyclerView: RecyclerView, view: View,
                            dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
            view.translationX = dX
            view.translationY = dY
        }

        override fun onDrawOver(c: Canvas, recyclerView: RecyclerView,
                                view: View, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

        }
    }
}
