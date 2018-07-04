package com.burhanrashid52.swipe.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 * @author <a href="https://github.com/burhanrashid52">Burhanuddin Rashid</a>
 * @since 7/4/2018
 */
abstract class BaseFragment : Fragment() {

    abstract fun getLayoutId(): Int

    abstract fun setupView(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayoutId() == 0) {
            throw RuntimeException("Invalid layout id")
        }
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view, savedInstanceState)
    }
}