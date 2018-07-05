package ja.burhanrashid52.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

/**
 * Created by Burhanuddin on 2/21/2018.
 */
abstract class BaseFragment : Fragment() {

    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayoutId() == 0) {
            throw RuntimeException("Invalid Layout ID")
        }
        return container?.inflate(getLayoutId())
    }

    /**
     * Is toggle the system UI flag i.e status and navigation bar for fullscreen mode
     */
    fun enableFullScreen(isEnabled: Boolean) {
        if (isEnabled) {
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        } else {
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }

    private var progressBarDialog: ProgressBarDialog? = null

    @JvmOverloads
    fun showLoading(isCancelable: Boolean = false) {
        showLoading(null, isCancelable)
    }

    @JvmOverloads
    fun showLoading(msg: String?, isCancelable: Boolean = false) {
        if (progressBarDialog == null) {
            progressBarDialog = ProgressBarDialog.show(childFragmentManager, isCancelable)
        } else {
            progressBarDialog?.dismiss()
            progressBarDialog?.show(childFragmentManager, ProgressBarDialog.TAG)
        }
    }

    fun hideLoading() {
        if (progressBarDialog?.isVisible!!) {
            progressBarDialog?.dismiss()
        }
    }

    /**
     * Hide the keyboard.
     *
     * @param view View in focus.
     */
    @JvmOverloads
    fun hideKeyboard(view: View?) {
        if (view != null) {
            val imm = view.context
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}