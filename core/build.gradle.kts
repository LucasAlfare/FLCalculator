@file:Suppress("LocalVariableName")

group = "com.lucasalfare.flcalculator"
version = "1.0-SNAPSHOT"

plugins {
  kotlin("jvm")
  id("org.jetbrains.compose")
}

dependencies {
  val lucasalfare_fllistening_version: String by project
  val lucasalfare_flbinary_version: String by project

  implementation(compose.desktop.currentOs)
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
  implementation("com.github.LucasAlfare:FLListening:$lucasalfare_fllistening_version")
  implementation("com.github.LucasAlfare:FLBinary:$lucasalfare_flbinary_version")

  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}