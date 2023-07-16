@file:Suppress("LocalVariableName")

plugins {
  kotlin("android")
  id("com.android.application")
  id("org.jetbrains.compose")
}

dependencies {
  val lucasalfare_fllistening_version: String by project
  val lucasalfare_flbinary_version: String by project

  implementation("androidx.activity:activity-compose:1.7.2")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("androidx.core:core-ktx:1.10.1")
  implementation("androidx.compose.animation:animation:1.4.3")
  implementation("androidx.compose.material:material:1.4.3")

  implementation("com.github.LucasAlfare:FLListening:$lucasalfare_fllistening_version")
  implementation("com.github.LucasAlfare:FLBinary:$lucasalfare_flbinary_version")

  implementation(project(":core"))
}

android {
  namespace = "com.lucasalfare.flcalculator"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.lucasalfare.flcalculator"
    minSdk = 26
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}