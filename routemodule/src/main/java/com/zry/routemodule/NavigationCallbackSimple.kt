package com.zry.routemodule

import android.os.Handler
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.dadaabc.zhuozan.dadaabcstudent.router.exception.RouterException
import io.reactivex.SingleEmitter


open class NavigationCallbackSimple : NavigationCallback {
    override fun onLost(postcard: Postcard) {
    }

    override fun onFound(postcard: Postcard) {
    }

    override fun onInterrupt(postcard: Postcard) {
    }

    override fun onArrival(postcard: Postcard) {
    }
}

class NavigationCallbackSingle(private val singleEmitter: SingleEmitter<Unit>, private val handler: Handler? = null) :
    NavigationCallbackSimple() {

    override fun onArrival(postcard: Postcard) {
        if (handler == null) {
            singleEmitter.onSuccess(Unit)
        } else {
            handler.post {
                singleEmitter.onSuccess(Unit)
            }
        }
    }

    override fun onLost(postcard: Postcard) {
        if (handler == null) {
            singleEmitter.onError(RouterException("not find route! $postcard"))
        } else {
            handler.post {
                singleEmitter.onError(RouterException("not find route! $postcard"))
            }
        }
    }

    override fun onInterrupt(postcard: Postcard) {
        if (handler == null) {
            singleEmitter.onError((postcard.tag as? Throwable) ?: RouterException("postcard onInterrupt !!! $postcard"))
        } else {
            handler.post {
                singleEmitter.onError(
                    (postcard.tag as? Throwable) ?: RouterException("postcard onInterrupt !!! $postcard")
                )
            }
        }
    }
}
