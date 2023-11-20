plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-android")
    id ("kotlin-kapt")
//    id ("kotlin-android-extensions")
}

android {
    namespace = "in.democracy.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "in.democracy.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.multidex:multidex:2.0.1")
    implementation ("androidx.browser:browser:1.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("androidx.activity:activity-ktx:1.8.1")

    //Circular Image View
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    implementation ("io.insert-koin:koin-android:3.3.0")
    implementation ("io.insert-koin:koin-androidx-navigation:3.3.0")

    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("com.github.bumptech.glide:glide:4.14.2")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")

    //Lottie Animation
    implementation("com.airbnb.android:lottie:6.1.0")

    //Runtime Permissions
    implementation("com.guolindev.permissionx:permissionx:1.6.1")
}