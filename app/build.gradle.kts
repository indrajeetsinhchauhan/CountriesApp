plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.indrajeet.chauhan.countriesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.indrajeet.chauhan.countriesapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val butterKnifeVersion = "10.1.0"
val supportVersion = "29.0.0"
val retrofitVersion = "2.3.0"
val glideVersion = "4.9.0"
val defVersion = "4.9.0"
val rxJavaVersion = "2.1.1"
val daggerVersion = "2.14.1"
val mockitoVersion = "2.11.0"
val lifeCycleExtensionVersion = "1.1.1"


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)

//    implementation("com.android.support:design:29.0.0")
//    implementation("android.arch.lifecycle:extensions:1.1.1")

//    implementation("com.jakewharton:butterknife:10.2.3")
//    annotationProcessor("com.jakewharton:butterknife-compiler:10.2.3")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.11.0")

//    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
//    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    implementation("com.github.bumptech.glide:glide:4.16.0")

    implementation("com.google.dagger:dagger:2.51.1")
    implementation("com.google.dagger:dagger-android:2.51.1")
    implementation("com.google.dagger:dagger-android-support:2.51.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    annotationProcessor("com.google.dagger:dagger-compiler:2.51.1")
    annotationProcessor("com.google.dagger:dagger-android-processor:2.51.1")

    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("android.arch.core:core-testing:1.1.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}