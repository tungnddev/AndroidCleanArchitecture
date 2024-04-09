object Versions {
    const val kotlin = "1.7.20"
    const val androidPlugin = "7.3.1"
    const val hilt = "2.44.2"
    const val composeCompiler = "1.3.2"

    internal const val coroutines = "1.3.9"
    internal const val retrofit = "2.9.0"
    internal const val okLogging = "4.10.0"
    internal const val room = "2.4.3"
    internal const val timber = "5.0.1"


    internal const val jUnit = "4.13.2"
    internal const val mockito = "4.8.0"
    internal const val mockWebserver = "4.10.0"
    internal const val coroutinesTest = "1.6.4"
    internal const val jUnitExtension = "1.1.4"
    internal const val testRunner = "1.5.1"
    internal const val robolectric = "4.9"
    internal const val robolectricAndroidXEnv = "1.5.0"
    internal const val paging = "3.1.1"
    internal const val pagingCompose = "1.0.0-alpha17"
    internal const val composeBom = "2022.12.00"
    internal const val navigation = "2.5.3"
}

object Url {

}

object Android {
    const val minSdk = 21
    const val targetSdk = 33
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

    const val environmentFlavor = "environment"
}

object Environment {
    const val flavor = "environment"
    const val development = "development"
    const val production = "production"
}

object AndroidJUnit {
    const val runner = "androidx.test.runner.AndroidJUnitRunner"
}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object GradlePlugins {
    const val android = "com.android.application"
    const val androidLib = "com.android.library"
    const val hilt = "com.google.dagger.hilt.android"
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
    const val presentation = "com.greaper.presentation"
    const val domain = "com.greaper.domain"
    const val data = "com.greaper.data"
}

object Libs {
    //
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // junit for testing
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitExtension = "androidx.test.ext:junit:${Versions.jUnitExtension}"

    // mockito for mocking data
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockWebserver = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserver}"

    // runner testing
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"

    // testing coroutines
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"

    // hilt dependency injection
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    // retrofit call API
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okLogging}"

    // room local db
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKotlin = "androidx.room:room-ktx:${Versions.room}"

    // Timber for logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // robolectric for testing
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val robolectricAndroidXEnv = "androidx.test:core:${Versions.robolectricAndroidXEnv}"

    // paging for paginate
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"
    const val pagingComposeExt = "androidx.paging:paging-compose:${Versions.pagingCompose}"

    // compose UI
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeMaterial = "androidx.compose.material:material"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUITooling = "androidx.compose.ui:ui-tooling"

    // navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigation}"
}