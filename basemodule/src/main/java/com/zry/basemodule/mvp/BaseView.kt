package com.zry.basemodule


interface BaseView {

    fun showLoading(msg: String? = null)

    fun hideLoading()

    fun setRefresh(active: Boolean)

    fun toastError(error: Throwable?)

    fun hidePlaceholder()

    fun showError()

    fun showEmpty()
}
