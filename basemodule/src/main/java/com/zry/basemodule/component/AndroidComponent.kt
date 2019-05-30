package com.zry.basemodule.component

import android.app.Application
import android.content.Context

interface AndroidComponent {

    /**
     * 返回组件名称，不可和其他组件重复
     */
    fun name(): String

    /**
     * 初始化操作，目前在每个进程会执行一次
     */
    fun initialization(application: Application)

    /**
     * 无参数启动组建
     *
     * @return true 启动成功  false 不支持启动
     */
    fun launcher(context: Context): Boolean
}
