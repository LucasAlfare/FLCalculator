package com.lucasalfare.flcalculator.core

data class CalculatorState(
  val currentTokens: List<String> = mutableListOf()
)