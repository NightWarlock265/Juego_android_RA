plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)


    // Para integrar KSP
    alias(libs.plugins.kotlin.ksp)

    // Para integrar en el proyecto Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "mx.uacj.juego_ra"
    compileSdk = 35

    defaultConfig {
        applicationId = "mx.uacj.juego_ra"
        minSdk = 24
        targetSdk = 35
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
        compose = true
    }
}

dependencies {
    // Para integrar Dagger Hilt y sus herramientas necesarias.
    implementation(libs.hilt.android)
    implementation(libs.hilt.viewmodel)
    ksp(libs.hilt.android.compilador)

    val androidxhiltCompiler = "1.3.0" // Cambioar a 1.2.0
    implementation("androidx.hilt:hilt-work:${androidxhiltCompiler}")
    ksp("androidx.hilt:hilt-compiler:${androidxhiltCompiler}")

    // Dependencia para Hilt y evitar errores extraños
    implementation("androidx.work:work-runtime-ktx:2.7.0")


    //    // Implementa las librerias de Navigation Compose
    implementation(libs.androidx.navigation.compose.android)

    //Implementa las librerias de Kotlinx para parcelizar (o utilizar JSON)
    implementation(libs.kotlinx.serialization.json)

    // Librerias necesarias para pdeir y gestioanr el tema de permisos y del uso de GPS:
    implementation("com.google.android.gms:play-services-location:21.3.0")
    implementation("com.google.accompanist:accompanist-permissions:0.35.0-alpha") // Esta dependencia nos permite manejar el tema de permisos relacionados con cualqueir cosa.

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}