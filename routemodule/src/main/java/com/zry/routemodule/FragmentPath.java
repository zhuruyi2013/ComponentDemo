package com.zry.routemodule;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;


@StringDef({
    RouterConstants.Fragment.HOME
})
@Retention(SOURCE)
public @interface FragmentPath {

}
