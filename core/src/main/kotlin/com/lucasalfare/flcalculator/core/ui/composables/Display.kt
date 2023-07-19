package com.lucasalfare.flcalculator.core.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.lucasalfare.flcalculator.core.ui.display

@Composable
fun Display() {
  Text(
    text = display,
    textAlign = TextAlign.End,
    modifier = Modifier.fillMaxSize()
  )
}