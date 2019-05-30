package com.zry.thirdmodule

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.zry.basemodule.BaseActivity
import com.zry.routemodule.RouterConstants
import kotlinx.android.synthetic.main.thirdmodule_activity_third.*

@Route(path = RouterConstants.PATH_ThIRD_THIRD)
class ThirdActivity : BaseActivity(), ThirdContact.View {

    private lateinit var presenter: ThirdContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thirdmodule_activity_third)
        setupPresenter()

        val name = intent.getStringExtra("name")
        thirdTv.text = name
    }

    private fun setupPresenter() {
        this.presenter = ThirdPresenter(this)
    }

    override fun onDestroy() {
        this.presenter.unSubscribe()
        super.onDestroy()
    }
}
