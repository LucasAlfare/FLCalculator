package com.lucasalfare.flcalculator.core.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucasalfare.flcalculator.core.AppEvent
import com.lucasalfare.flcalculator.core.ui.padScheme
import com.lucasalfare.flcalculator.core.ui.uiManager

@Composable
fun Pad() {
  Column {
    repeat(5) {
      Row(modifier = Modifier.weight(1f)) {
        padScheme.slice(it * 4..(it * 4) + 3).forEach {
          Box(modifier = Modifier.weight(1f)) {
            PadButton(it)
          }
        }
      }
    }
  }
}

@Composable
private fun PadButton(value: String) {
  Button(
    onClick = {
      uiManager.notifyListeners(AppEvent.Input, value)
    },
    modifier = Modifier.fillMaxSize().padding(2.dp)
  ) {
    Text(value)
  }
}