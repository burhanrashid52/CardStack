package com.burhanrashid52.swipe.home

import android.os.Bundle
import android.view.View
import com.burhanrashid52.swipe.R
import com.burhanrashid52.swipe.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_card.*

/**
 *
 * @author <a href="https://github.com/burhanrashid52">Burhanuddin Rashid</a>
 * @since 7/4/2018
 */
class CardFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_card

    companion object {
        const val EXTRA_POSITION = "extra_position"
        fun newInstance(position: Int): CardFragment {
            val bundle = Bundle()
            bundle.putInt(EXTRA_POSITION, position)
            val cardFragment = CardFragment()
            cardFragment.arguments = bundle
            return cardFragment
        }
    }


    override fun setupView(view: View, savedInstanceState: Bundle?) {
        val position = arguments?.getInt(EXTRA_POSITION, 0)
        txtLabel.text = "$position"
        when (position) {
            0 -> constraint.setBackgroundColor(resources.getColor(android.R.color.holo_red_dark))
            1 -> constraint.setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark))
            2 -> constraint.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
            3 -> constraint.setBackgroundColor(resources.getColor(android.R.color.holo_orange_dark))
            4 -> constraint.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
        }
    }
}