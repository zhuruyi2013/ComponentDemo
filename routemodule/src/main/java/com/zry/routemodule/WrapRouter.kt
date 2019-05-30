package com.zry.routemodule

import android.app.Application
import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import com.alibaba.android.arouter.core.LogisticsCenter
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import io.reactivex.Single

object WrapRouter {

    private val mainHandler = Handler(Looper.getMainLooper())

    fun init(application: Application) {
        ARouter.init(application)
    }

    fun openDebug() {
        ARouter.openLog()
        ARouter.openDebug()
    }

    fun build(path: String, block: (Postcard.(Postcard) -> Unit)) {
        mainHandler.post {
            val postcard = ARouter.getInstance().build(path)
            block.invoke(postcard, postcard)
        }
    }

    fun build(uri: Uri, block: (Postcard.(Postcard) -> Unit)) {
        mainHandler.post {
            val postcard = ARouter.getInstance().build(uri)
            block.invoke(postcard, postcard)
        }
    }

    // safe
    fun safeBuild(@PagePath path: String, block: (Postcard.(Postcard) -> Unit)) {
        mainHandler.post {
            val postcard = ARouter.getInstance().build(path)
            block.invoke(postcard, postcard)
        }
    }

    fun navigation(@PagePath path: String, context: Context? = null, block: (Postcard.() -> Unit)? = null):
        Single<Unit> {
        return Single.create<Unit> {
            mainHandler.post {
                val postCard = ARouter.getInstance().build(path)
                block?.invoke(postCard)
                postCard.navigation(context, NavigationCallbackSingle(it, mainHandler))
            }
        }
    }

    fun navigation(uri: Uri, context: Context? = null, block: (Postcard.() -> Unit)? = null): Single<Unit> {
        return Single.create<Unit> {
            mainHandler.post {
                val postCard = ARouter.getInstance().build(uri)
                block?.invoke(postCard)
                postCard.navigation(context, NavigationCallbackSingle(it, mainHandler))
            }
        }
    }

    fun findFragment(@FragmentPath path: String): Fragment? {
        return ARouter.getInstance().build(path).navigation() as? Fragment
    }

    /**
     *  ARouter不支持启动多个页面 可以通过该方法 查询到目标页面 手动启动
     */
    fun findDestination(path: String): Class<*>? {
        return try {
            val postcard = ARouter.getInstance().build(path)
            LogisticsCenter.completion(postcard)
            postcard.destination
        } catch (t: Throwable) {
            t.printStackTrace()
            null
        }
    }

    fun navigationToH5(context: Context, url: String, title: String? = null, entrance: String? = null) {
        safeBuild(RouterConstants.PATH_WEB) {
            withString("url", url)
            withString("head", title)
            withEntranceName(entrance)
            navigation(context)
        }
    }
}
