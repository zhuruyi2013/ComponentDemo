package com.zry.secondmodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.zry.routemodule.RouterConstants
import com.zry.routemodule.WrapRouter

class SecondDebugActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btn = Button(this)
        btn.text = "open Second Page a"
        btn.setOnClickListener {
            WrapRouter.navigation(RouterConstants.PATH_SECOND_SEC, this){
                withString("name", "debugSecond")
            }.subscribe()
        }
        setContentView(btn)

    }
}
