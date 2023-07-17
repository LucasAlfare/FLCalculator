package com.lucasalfare.flcalculator.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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