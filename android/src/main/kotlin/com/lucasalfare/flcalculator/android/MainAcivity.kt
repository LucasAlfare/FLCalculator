package com.lucasalfare.flcalculator.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.lucasalfare.flcalculator.core.ui.App

class MainAcivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      // shows up the core App composable
      App()
    }
  }
}