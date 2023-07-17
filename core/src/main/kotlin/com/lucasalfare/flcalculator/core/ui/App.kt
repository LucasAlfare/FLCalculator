package com.lucasalfare.flcalculator.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucasalfare.flcalculator.core.CalculatorManager
import com.lucasalfare.flcalculator.core.ui.composables.Display
import com.lucasalfare.flcalculator.core.ui.composables.Pad
import com.lucasalfare.fllistener.setupManagers

@Composable
fun App() {
  MaterialTheme {
    LaunchedEffect(Unit) {
      setupManagers(
        uiManager,
        CalculatorManager()
      )
    }

    Column {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .padding(4.dp)
      ) {
        Display()
      }
      Box(
        modifier = Modifier
          .padding(4.dp)
          .weight(3f)
      ) {
        Pad()
      }
    }
  }
}