package com.lucasalfare.flcalculator.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.lucasalfare.flcalculator.core.CalculatorManager
import com.lucasalfare.fllistener.setupManagers

@Composable
fun App() {
  LaunchedEffect(Unit) {
    setupManagers(
      uiManager,
      CalculatorManager()
    )
  }

  Column {
    Button(
      modifier = Modifier.fillMaxSize(),
      onClick = {}
    ) {
      Text("Click!")
    }
  }
}