package ja.burhanrashid52.base

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

class ProgressBarDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return ProgressBar(activity)
    }

    companion object {

        val TAG = ProgressBarDialog::class.java.simpleName

        @JvmOverloads
        fun show(appCompatActivity: AppCompatActivity, isCancelable: Boolean = false): ProgressBarDialog {
            return show(appCompatActivity.supportFragmentManager, isCancelable)
        }

        @JvmOverloads
        fun show(parentFragment: FragmentManager, isCancelable: Boolean = false): ProgressBarDialog {
            val progressBarDialog = ProgressBarDialog()
            progressBarDialog.isCancelable = isCancelable
            progressBarDialog.show(parentFragment, TAG)
            return progressBarDialog
        }
    }
}