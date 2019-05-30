package com.zry.routemodule;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;


@StringDef({
    RouterConstants.PATH_MAIN,
    RouterConstants.PATH_SECOND_SEC,
    RouterConstants.PATH_ThIRD_THIRD
})
@Retention(SOURCE)
public @interface PagePath {

}
