package com.zry.basemodule.component

import android.app.Application
import android.content.Context
import android.util.Log
import java.util.Collections
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.collections.HashMap
import kotlin.collections.set

/**
 * Created by 王天明 on 2019/1/14.
 */

object ComponentManager {

    private val componentMap = HashMap<String, AndroidComponent>()

    private val isInit = AtomicBoolean(false)

    private const val TAG = "ComponentManager"

    @JvmStatic
    @Throws(AndroidComponentAlreadyExistException::class)
    private fun register(component: AndroidComponent) {
        if (componentMap.containsKey(component.name())) {
            throw AndroidComponentAlreadyExistException(
                "${component.name()} is already exist [${componentMap[component.name()]?.javaClass?.canonicalName}]" +
                    " your is [${component.javaClass.canonicalName}]"
            )
        }
        componentMap[component.name()] = component
    }

    fun init(application: Application) {
        if (isInit.compareAndSet(false, true)) {
            componentMap.forEach {
                Log.d(TAG, "ComponentManager: --- start init ${it.key} ---")
                it.value.initialization(application)
                Log.d(TAG, "ComponentManager: ---  end  init ${it.key} ---")
            }
        }
    }

    @Throws(AndroidComponentNotFoundException::class)
    fun launcherComponent(context: Context, name: String): Boolean {
        val component =
            componentMap[name] ?: throw AndroidComponentNotFoundException("Could not fount component: $name")
        return component.launcher(context)
    }

    fun getAllCompinentNames(): MutableSet<String> {
        return Collections.unmodifiableSet(componentMap.keys)
    }
}
