plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // Настройка плагинов для Hilt
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.kotlinKapt) apply false
}