plugins {
    id(GradlePlugins.androidLib)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
}

android {
    namespace = Namespace.domain
    compileSdk = Android.targetSdk
}

dependencies {
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.retrofitGson)
    implementation(Libs.paging)
    testImplementation(Libs.coroutinesTest)
    testImplementation(Libs.jUnit)
    testImplementation(Libs.mockito)

}