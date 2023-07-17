package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking

class NumberState: ParsingState {

  private var currentNumber = ""

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
    onStateUpdate: (String) -> Unit
  ) {
    when (input) {
      "." -> {
        if (input !in currentNumber) {
          val nextItem = (if (currentNumber.isEmpty()) "0." else ".")
          currentNumber += nextItem
          onStateUpdate(nextItem)
        }
      }

      "0" -> {
        if (currentNumber.isNotEmpty()) {
          currentNumber += input
          onStateUpdate(input)
        }
      }

      else -> {
        currentNumber += input
        onStateUpdate(input)
      }
    }
  }
}