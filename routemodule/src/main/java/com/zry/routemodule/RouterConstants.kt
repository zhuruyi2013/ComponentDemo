package com.zry.routemodule

// module
private const val MODULE_APP = "app"

private const val MODULE_SECOND = "second"

private const val MODULE_THIRD = "third"

object RouterConstants {
    // App
    const val PATH_MAIN = "/$MODULE_APP/main"

    // SecondModule
    const val PATH_SECOND_SEC = "/$MODULE_SECOND/sec"

    // ThirdModule
    const val PATH_ThIRD_THIRD = "/$MODULE_THIRD/third"


    const val PATH_WEB = "/$MODULE_APP/web"


    object Interceptor {
        const val NEED_USER: Int = 0x9987653321.toInt()
    }

    object Fragment {
        const val HOME = "/fragment/home"
    }

    object KEY {

        object App {
            const val APP_SCHEME_URI = "app_scheme_url"
        }
    }
}
