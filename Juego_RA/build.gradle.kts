// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // Integracion al proyecto deo uso de KSP como herramienta de desarrollo
    alias(libs.plugins.kotlin.ksp) apply false

    /// Si algo falla, cambiar este primero por favor
    // Para integrar Hilt en el proyecto
    id("com.google.dagger.hilt.android") version "2.56" apply false
    // Para usar Parcelize
    alias(libs.plugins.kotlin.parcelize) apply false
}