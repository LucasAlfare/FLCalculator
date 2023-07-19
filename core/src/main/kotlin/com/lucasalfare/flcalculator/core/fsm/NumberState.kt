package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking

class NumberState(var currentNumber: String = ""): ParsingState {

  override fun handleInput(
    input: String
  ): ParsingState? {
    return when {
      InputChecking.isOperator(input) -> OperationState()
      InputChecking.isClosingAssociative(input) -> ClosingAssociativeState()
      InputChecking.isNumeric(input) || InputChecking.isDot(input) -> this

      else -> null
    }
  }

  override fun update(
    input: String,
    onStateUpdate: (String, Boolean) -> Unit
  ) {
    when (input) {
      "." -> {
        if (input !in currentNumber) {
          val nextItem = (if (currentNumber.isEmpty()) "0." else ".")
          currentNumber += nextItem
          onStateUpdate(currentNumber, true)
        }
      }

      "0" -> {
        if (currentNumber.isNotEmpty()) {
          currentNumber += input
          onStateUpdate(currentNumber, true)
        }
      }

      else -> {
        currentNumber += input
        onStateUpdate(currentNumber, true)
      }
    }
  }
}