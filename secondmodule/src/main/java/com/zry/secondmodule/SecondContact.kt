package com.zry.secondmodule

import com.zry.basemodule.BasePresenter
import com.zry.basemodule.BaseView


interface SecondContact {

    interface View : BaseView {
        fun showSecondView()
    }

    interface Presenter : BasePresenter {
        fun requestData()
    }

}
