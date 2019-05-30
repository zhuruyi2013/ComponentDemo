package com.zry.thirdmodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.zry.routemodule.RouterConstants
import com.zry.routemodule.WrapRouter

/**
 * Created by 王天明 on 2019/3/6.
 */
class ThirdDebugActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btn = Button(this)
        btn.text = "open Third page a"
        btn.setOnClickListener {
            WrapRouter.navigation(RouterConstants.PATH_ThIRD_THIRD, this){
                withString("name", "debugThird")
            }.subscribe()
        }
        setContentView(btn)

    }
}
