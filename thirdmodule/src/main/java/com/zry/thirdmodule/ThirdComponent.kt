package com.zry.thirdmodule

import android.app.Application
import android.content.Context
import android.util.Log
import com.zry.basemodule.component.AndroidComponent

/**
 * Created by zhuruyi on 2019-05-30.
 * Copyright  2018 henzry.zhu@dadaabc.com. All rights reserved
 */
class ThirdComponent  : AndroidComponent {
    /**
     * 返回组件名称，不可和其他组件重复
     */
    override fun name(): String {
        return "Third"
    }

    /**
     * 初始化操作，目前在每个进程会执行一次
     */
    override fun initialization(application: Application) {
        Log.d("third", "do some init work")
    }

    /**
     * 无参数启动组建
     *
     * @return true 启动成功  false 不支持启动
     */
    override fun launcher(context: Context): Boolean {
        return false
    }

}
