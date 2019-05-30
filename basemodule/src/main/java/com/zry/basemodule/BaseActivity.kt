package com.zry.basemodule

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/**
 * Created by 王天明 on 2019/1/4.
 */

open class BaseActivity :  AppCompatActivity(), BaseView {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
    }


    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        if (intent.resolveActivity(packageManager) == null)
            return
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION)
        super.startActivityForResult(intent, requestCode)
    }

    private fun handleIntentActivityCheck(intent: Intent): Boolean {
        return intent.resolveActivity(packageManager) != null
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun finish() {
        hideSoftInput()
        super.finish()
    }

    override fun setRefresh(active: Boolean) {
    }

    override fun showLoading(msg: String?) {}

    override fun hideLoading() {}

    override fun toastError(error: Throwable?) {

    }

    override fun hidePlaceholder() = Unit

    override fun showError() = Unit

    override fun showEmpty() = Unit

    override fun attachBaseContext(base: Context?) {
        var newContext: Context? = base
        super.attachBaseContext(newContext)
    }

    protected fun hideSoftInput() {
        val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus
        if (view != null) {
            im.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

}
