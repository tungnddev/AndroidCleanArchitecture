object Versions {
    const val kotlin = "1.7.20"
    const val androidPlugin = "7.3.1"

    internal const val coroutines = "1.3.9"

    internal const val jUnit = "4.13.2"
    internal const val mockito = "4.8.0"
    internal const val coroutinesTest = "1.6.4"
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

object Namespace {
    const val presentation = "com.greaper.androidcleanarchitecture"
    const val domain = "com.greaper.domain"
    const val data = "com.greaper.data"
}

object Libs {
    //
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // junit for testing
    const val jUnit = "junit:junit:${Versions.jUnit}"

    // mockito for mocking data
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"

    // testing coroutines
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
}