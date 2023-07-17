package com.lucasalfare.flcalculator.core

enum class AppEvent {
  Input,
  TestingEvent
}

class InputChecking {
  companion object {
    fun isNumeric(s: String) = s in "0123456789"

    fun isOperator(s: String) = s in "+-*/"

    fun isAssociative(s: String) = s in "()[]{}"

    fun isDot(s: String) = s == "."

    fun isEquality(s: String) = s == "="

    fun isErase(s: String) = s == "<"
  }
}
