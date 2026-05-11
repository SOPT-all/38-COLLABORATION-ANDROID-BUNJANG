import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties
import kotlin.apply

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.ksp)
}

val properties = Properties().apply {
    load(project.rootProject.file("local.properties").inputStream())
}

android {
    namespace = "com.sopt.bunjang"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sopt.bunjang"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", properties["base.url"].toString())
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    dependencies {
        // AndroidX Core & Lifecycle
        implementation(libs.bundles.androidx.core)

        // Compose
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.bundles.compose)
        debugImplementation(libs.bundles.compose.debug)

        // Navigation (SAA 적용)
        implementation(libs.androidx.navigation.compose)

        // Network
        implementation(libs.bundles.network)

        // Kotlinx
        implementation(libs.kotlinx.immutable)
        implementation(libs.kotlinx.serialization.json)

        // Room
        implementation(libs.bundles.room)
        ksp(libs.androidx.room.compiler)

        // Test
        testImplementation(libs.junit)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.bundles.androidTest)

        // Hilt
        implementation(libs.bundles.hilt)
        ksp(libs.hilt.compiler)

        // Timber
        implementation(libs.timber)
    }
}