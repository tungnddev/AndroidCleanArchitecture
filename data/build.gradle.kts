import java.io.File
import java.io.FileInputStream
import java.util.*
import com.android.build.api.variant.*

plugins {
    id(GradlePlugins.androidLib)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
    id(GradlePlugins.hilt)
}

android {
    namespace = Namespace.data
    compileSdk = Android.targetSdk

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = AndroidJUnit.runner
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
    sourceSets {
        getByName("main") {
            resources {
                srcDirs("src\\main\\resources", "src\\test\\resources")
            }
        }
    }

}

androidComponents {
    onVariants { variant ->
        val flavor = variant.flavorName
        // To check for a certain build type, use variant.buildType.name == "<buildType>"
        val envProperties = Properties()
        val envPropertiesFile = File("$rootDir/data/$flavor.properties")
        if (envPropertiesFile.exists()) {
            envProperties.load(FileInputStream(envPropertiesFile))
        }
        variant.buildConfigFields.put(
            "API_ENDPOINT",
            BuildConfigField("String", envProperties.getProperty("apiEndpoint"), null)
        )
        variant.manifestPlaceholders.put("scheme", envProperties.getProperty("appScheme"))
    }
}

dependencies {
    implementation(project(Modules.domain))

    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)

    implementation(Libs.retrofit)
    implementation(Libs.retrofitGson)
    implementation(Libs.okLogging)

    implementation(Libs.roomRuntime)
    kapt(Libs.roomCompiler)
    implementation(Libs.roomKotlin)

    implementation(Libs.coroutinesAndroid)
    testImplementation(Libs.coroutinesTest)

    implementation(Libs.timber)

    testImplementation(Libs.jUnit)
    testImplementation(Libs.mockito)
    testImplementation(Libs.robolectric)
    testImplementation(Libs.robolectricAndroidXEnv)
    testImplementation(Libs.mockWebserver)

}