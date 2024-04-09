plugins {
    id(GradlePlugins.android)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
    id(GradlePlugins.hilt)
}

android {
    namespace = Namespace.presentation
    compileSdk = Android.targetSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = AndroidJUnit.runner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = false
        }
    }

    flavorDimensions += Environment.flavor

    productFlavors {
        create(Environment.development) {
            dimension = Environment.flavor
        }
        create(Environment.production) {
            dimension = Environment.flavor
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

dependencies {
    implementation(project(Modules.data))

    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)

    implementation(Libs.coroutinesAndroid)
    testImplementation(Libs.coroutinesTest)

    implementation(Libs.paging)

    testImplementation(Libs.jUnit)
    testImplementation(Libs.jUnitExtension)

    implementation(platform(Libs.composeBom))
    androidTestImplementation(platform(Libs.composeBom))
    implementation(Libs.composeMaterial)
    implementation(Libs.composePreview)
    debugImplementation(Libs.composeUITooling)

    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUI)
    implementation(Libs.navigationCompose)
}