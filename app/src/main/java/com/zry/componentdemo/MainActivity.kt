package com.zry.componentdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.zry.routemodule.RouterConstants
import com.zry.routemodule.WrapRouter
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/main/home")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumpToSecondModule.setOnClickListener {
            WrapRouter.navigation(RouterConstants.PATH_SECOND_SEC, this){
                withString("name", "zhangsan")
            }.subscribe({
                //TODO finish or not
            }, {
                it.printStackTrace()
            })
//            startActivity(Intent(this, SecondActivity::class.java))
        }

        jumpToThirdModule.setOnClickListener {
            WrapRouter.navigation(RouterConstants.PATH_ThIRD_THIRD, this){
                withString("name", "lisi")
            }.subscribe({
                //TODO finish or not
            }, {
                it.printStackTrace()
            })
        }
    }
}
