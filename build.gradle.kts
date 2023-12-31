group = "com.lucasalfare.flcalculator"
version = "1.0-SNAPSHOT"

plugins {
  kotlin("jvm") apply false

  kotlin("android") apply false
  id("com.android.application") apply false
  id("com.android.library") apply false

  id("org.jetbrains.compose") apply false
}

allprojects {
  repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}

/**
 * Task used to re-generate wrappers, if needed.
 */
tasks.withType<Wrapper> {
  gradleVersion = "7.6.1"
}