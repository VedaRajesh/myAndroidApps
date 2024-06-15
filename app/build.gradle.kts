plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.securenote"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.securenote"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
vectorDrawables.useSupportLibrary=true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding=true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.glide)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.google.material)
    implementation(libs.gradle.core)
    implementation(libs.google.services)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //noinspection KaptUsageInsteadOfKsp
//    kapt(libs.androidx.room.compiler)
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}