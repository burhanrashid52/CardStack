package ja.burhanrashid52.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ja.burhanrashid52.base.repo.Resource

open class BaseViewModel : ViewModel() {
    val uiProgressObserver = MutableLiveData<Resource<Int>>()
}