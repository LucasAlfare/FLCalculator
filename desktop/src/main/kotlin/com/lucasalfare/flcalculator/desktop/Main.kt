package com.lucasalfare.flcalculator.desktop

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.lucasalfare.flcalculator.core.ui.App

fun main() = application {
  Window(
    state = WindowState(
      position = WindowPosition(Alignment.Center),
      size = DpSize(300.dp, 400.dp)
    ),
    onCloseRequest = { this.exitApplication() }
  ) {
    // shows up the core App composable
    App()
  }
}