package com.lucasalfare.flcalculator.core


enum class CalculatorStateTokenType {
  Numeric,
  Operation,
  Unspecified
}

data class CalculatorStateToken(
  var value: String = "",
  var type: CalculatorStateTokenType = CalculatorStateTokenType.Unspecified
)

class CalculatorState {
  val currentCalculatorTokens = mutableListOf<CalculatorStateToken>()

  private var tmpToken: CalculatorStateToken? = null

  fun handleInput(s: String) {
    if (s != " ") {
      tmpToken = CalculatorStateToken()
    }
  }
}

private fun isNumeric(s: String) = s in "0123456789"

private fun isDot(s: String) = s == "."

private fun isOperation(s: String) = s in "+-*/"

private fun isAssociative(s: String) = s in "()[]{}"

private fun isEquality(s: String) = s == "="