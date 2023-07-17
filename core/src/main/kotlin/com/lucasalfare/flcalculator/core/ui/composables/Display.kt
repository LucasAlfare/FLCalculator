package com.lucasalfare.flcalculator.core.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.lucasalfare.flcalculator.core.ui.displayText

@Composable
fun Display() {
  Text(
    text = displayText,
    fontSize = 24.sp,
    fontFamily = FontFamily.Monospace,
    textAlign = TextAlign.End,
    modifier = Modifier.fillMaxSize()
  )
}