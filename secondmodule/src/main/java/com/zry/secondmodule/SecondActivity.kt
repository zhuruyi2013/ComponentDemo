package com.zry.secondmodule

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.zry.basemodule.BaseActivity
import com.zry.routemodule.RouterConstants
import kotlinx.android.synthetic.main.secondmodule_activity_second.*

@Route(path = RouterConstants.PATH_SECOND_SEC)
class SecondActivity : BaseActivity(), SecondContact.View {
    private lateinit var presenter: SecondContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondmodule_activity_second)
        setupPresenter()

        val name = intent.getStringExtra("name")
        secTv.text = name
    }

    override fun showSecondView() {
        //TODO() will call from presenter to control view
    }

    private fun setupPresenter() {
        this.presenter = SecondPresenter(this)
    }

    override fun onDestroy() {
        this.presenter.unSubscribe()
        super.onDestroy()
    }
}
