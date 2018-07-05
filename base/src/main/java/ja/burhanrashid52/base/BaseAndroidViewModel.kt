package ja.burhanrashid52.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import ja.burhanrashid52.base.repo.Resource

open class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {
    val uiProgressObserver = MutableLiveData<Resource<Int>>()
}
