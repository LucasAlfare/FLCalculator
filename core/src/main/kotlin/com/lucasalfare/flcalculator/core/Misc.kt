package com.lucasalfare.flcalculator.core

enum class AppEvent {
  Input,
  TestingEvent
}

class InputChecking {
  companion object {
    fun isNumeric(s: String) = s in "0123456789"

    fun isOperator(s: String) = s in "+-*/"

    fun isDot(s: String) = s == "."

    fun isOpenningAssociative(s: String) = s in "([{"

    fun isClosingAssociative(s: String) = s in ")]}"
  }
}

public fun List<CalculatorToken>.customLast(): CalculatorToken {
  return if (isEmpty()) CalculatorToken() else this[size - 1]
}
