package com.zry.basemodule

import android.annotation.SuppressLint
import android.arch.lifecycle.GenericLifecycleObserver
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Lifecycle.Event
import android.arch.lifecycle.LifecycleOwner

@SuppressLint("RestrictedApi")
abstract class AbsBasePresenter(view: BaseView) : BasePresenter, GenericLifecycleObserver {
    init {
        if (view is LifecycleOwner) {
            view.lifecycle.addObserver(this)
        }
    }

    override fun onStateChanged(source: LifecycleOwner?, event: Event?) {
        if (source?.lifecycle?.currentState == Lifecycle.State.DESTROYED) {
            source.lifecycle.removeObserver(this)
            unSubscribe()
        }
    }
}
