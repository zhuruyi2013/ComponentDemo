package com.zry.routemodule

import android.app.Activity
import android.content.Intent
import com.alibaba.android.arouter.facade.Postcard

const val KEY_ROUTER_ENTRANCE_NAME = "key_router_entrance_name"

inline fun Postcard.withEntranceName(entrance: String?): Postcard {
    this.withString(KEY_ROUTER_ENTRANCE_NAME, entrance)
    return this
}

inline fun Intent?.getRouterEntranceName(): String? {
    return this?.getStringExtra(KEY_ROUTER_ENTRANCE_NAME)
}

inline fun Activity?.getRouterEntranceName(): String? {
    return this?.intent?.getRouterEntranceName()
}
