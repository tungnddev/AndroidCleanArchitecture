object Versions {
    const val kotlin = "1.7.20"
    const val androidPlugin = "7.3.1"
}

object Url {

}

object Android {
    const val minSdk = 21
    const val targetSdk = 29
    const val applicationId = "com.greaper.androidcleanarchitecture"
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildType {
    const val debug = "debug"
    const val release = "release"

    const val minifyRelease = false
    const val proguardRelease = "proguard-rules.pro"

    const val minifyDebug = false
    const val proguardDebug = "proguard-rules.pro"
}

object Libs {

}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object GradlePlugins {
    const val android = "com.android.application"
    const val androidLib = "com.android.library"
    const val hilt = "dagger.hilt.android.plugin"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinApt = "kapt"
    const val javaLib = "java-library"
    const val navigationSafe = "androidx.navigation.safeargs"
    const val navigationSafeKotlin = "androidx.navigation.safeargs.kotlin"
    const val playService = "com.google.gms.google-services"
}

object BuildPlugins {

}