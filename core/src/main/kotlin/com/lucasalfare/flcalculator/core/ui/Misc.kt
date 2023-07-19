package com.lucasalfare.flcalculator.core.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.buildAnnotatedString
import com.lucasalfare.fllistener.CallbacksManager

val uiManager = CallbacksManager()

val padScheme = arrayOf(
  "<", "(", ")", "C",
  "7", "8", "9", "/",
  "4", "5", "6", "*",
  "1", "2", "3", "-",
  "0", ".", "=", "+"
)

var display by mutableStateOf(buildAnnotatedString { append("0") })