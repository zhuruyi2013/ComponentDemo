package com.zry.thirdmodule

import android.app.Application
import com.zry.basemodule.component.ComponentManager
import com.zry.routemodule.WrapRouter

/**
 * Created by 王天明 on 2019/1/17.
 */
class ThirdDebugApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        WrapRouter.init(this)
        ComponentManager.init(this)
    }
}
