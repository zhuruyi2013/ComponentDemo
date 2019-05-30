package com.zry.componentdemo

import android.app.Application
import com.zry.basemodule.component.ComponentManager
import com.zry.routemodule.WrapRouter

/**
 * Created by zhuruyi on 2019-05-29.
 * Copyright  2018 henzry.zhu@dadaabc.com. All rights reserved
 */
class DemoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            WrapRouter.openDebug()
        }
        WrapRouter.init(this)

        ComponentManager.init(this)
    }
}
