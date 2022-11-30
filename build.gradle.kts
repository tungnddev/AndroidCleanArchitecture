// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(GradlePlugins.android) version Versions.androidPlugin apply false
    id(GradlePlugins.androidLib) version Versions.androidPlugin apply false
    kotlin(GradlePlugins.kotlinAndroid) version Versions.kotlin apply false
}