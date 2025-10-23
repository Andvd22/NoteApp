plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-parcelize")
    // SỬA: Dùng alias cho KSP
    alias(libs.plugins.ksp)
    // SỬA: Dùng alias cho Navigation SafeArgs
    alias(libs.plugins.navigation.safeargs)
}

android {
    namespace = "com.example.noteapp"
    // SỬA: HẠ compileSdk về bản ổn định (34)
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.noteapp"
        minSdk = 24
        // SỬA: HẠ targetSdk về bản ổn định (34)
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // ROOM
    // SỬA: Sử dụng version từ toml
    val roomVersion = libs.versions.room.get()
    implementation ("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // Coroutines
    // SỬA: Sử dụng version 1.8.1 (từ toml)
    val coroutinesVersion = libs.versions.coroutines.get()
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")

    // Navigation
    // SỬA: Sử dụng version 2.7.5 (từ toml)
    val navVersion = libs.versions.nav.get()
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Life Cycle Arch
    // SỬA: Sử dụng version 2.7.0 (từ toml)
    val lifecycleVersion = libs.versions.lifecycle.get()
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    // Annotation processor
    ksp("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
}