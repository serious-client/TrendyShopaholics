plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.firebase.appdistribution)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.nkechinnaji.trendyshopaholics"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nkechinnaji.trendyshopaholics"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug"){
            //applicationIdSuffix = ".debug"
            isDebuggable = true
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
        release {
            firebaseAppDistribution {
                releaseNotesFile="/path/to/releasenotes.txt"
                testers="ali@example.com, bri@example.com, cal@example.com"
            }
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        productFlavors {
            debug {
                applicationIdSuffix
                firebaseAppDistribution {
                    appId = "1:977752964163:android:93ca6623bcf62fdf3768f6"
                    groups = "serious-client-team"
                    releaseNotes="Release notes for debug version"
                    testers="nkechi.nnaji@gmail.com"
                    serviceCredentialsFile = "firebase_app_distribution_google_service.json"
                }
            }
            release {
                firebaseAppDistribution {
                    appId = "1:977752964163:android:93ca6623bcf62fdf3768f6"
                    groups = "serious-client-team"
                    releaseNotes="Release notes for production version"
                    testers="nkechi.nnaji@gmail.com"
                    serviceCredentialsFile = "firebase_app_distribution_google_service.json"
                }
            }
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(platform("com.google.firebase:firebase-bom:33.5.0"))
    implementation("com.google.firebase:firebase-analytics")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}