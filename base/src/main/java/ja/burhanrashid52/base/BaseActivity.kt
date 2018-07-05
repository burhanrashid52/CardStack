package ja.burhanrashid52.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.inputmethod.InputMethodManager


/**
 * Created by Burhanuddin on 2/21/2018.
 */
open class BaseActivity : AppCompatActivity() {

    /**
     * Is toggle the system UI flag i.e status and navigation bar for fullscreen mode
     */
    fun enableFullScreen(isEnabled: Boolean) {
        if (isEnabled) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
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
            progressBarDialog = ProgressBarDialog.show(supportFragmentManager!!, isCancelable)
        } else {
            progressBarDialog?.dismiss()
            progressBarDialog?.show(supportFragmentManager, ProgressBarDialog.TAG)
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