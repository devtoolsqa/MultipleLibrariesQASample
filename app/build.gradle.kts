
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.androidx.navigation.safeargs)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.google.services)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlin.parcelize)

}


android {
  /*  signingConfigs {
        create("release") {
            storeFile = file("C:\\Users\\sandeeppadala\\key-store\\api33.jks")
            storePassword = "123456"
            keyAlias = "key0"
            keyPassword = "123456"
        }
    }*/
    namespace = "com.example.kotlinpracticeudemy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlinpracticeudemy"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
           // signingConfig = signingConfigs.getByName("release")
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
        viewBinding = true
    }
    viewBinding{
        enable=true
    }
    lint {
        baseline = file("lint-baseline.xml")
        abortOnError=false
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    //implementation(libs.firebase.crashlytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.work.runtime.ktx)
    implementation(libs.glide)

    // ViewModel and LiveData
    implementation(libs.androidx.lifecycle.extensions)
    kapt(libs.androidx.lifecycle.common.java8)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)

    implementation(libs.androidx.window)
    implementation(libs.androidx.startup.runtime)





    //Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    //implementation(libs.androidx.hilt.lifecycle.viewmodel)
    kapt(libs.androidx.hilt.compiler)



    //Firebase
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.firebase.database.ktx)
    implementation(libs.kotlinx.coroutines.play.services)

    //Gson
    implementation(libs.gson)

    //ImagePicker
    implementation(libs.imagepicker)

}