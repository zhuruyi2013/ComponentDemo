object Versions {
    val support_lib = "28.0.0"
    val constrait = "1.1.3"
    val kotlin_version = "1.3.20"

    const val applicationId = "com.zry.componentdemo"
    const val compileSdkVersion = 28
    const val minSdkVersion = 19
    const val targetSdkVersion = 28
    const val versionCode = 266
    const val versionName = "2.17.0"
    const val libRxKotlinVersion = "2.1.0"

}

object Libs {
    val support_annotations = "com.android.support:support-annotations:${Versions.support_lib}"
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    val constraint = "com.android.support.constraint:constraint-layout:${Versions.constrait}"
    val kotlinJDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val ARouterLib = "com.alibaba:arouter-api:1.4.1"
    val ARouterCompiler = "com.alibaba:arouter-compiler:1.2.2"
    const val libRxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.libRxKotlinVersion}"
}
