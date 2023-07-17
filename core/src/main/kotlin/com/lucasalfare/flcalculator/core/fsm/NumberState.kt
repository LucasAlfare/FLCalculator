package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking

class NumberState: ParsingState {

  private var currentNumber = ""

  override fun handleInput(input: String): ParsingState? {
    if (InputChecking.isOperator(input)) {

    } else if (InputChecking.isAssociative(input)) {

    } else if (InputChecking.isEquality(input)) {

    } else if (InputChecking.isErase(input)) {

    } else if (InputChecking.isNumeric(input)) {
      return this
    }

    return null
  }

  override fun update(
    input: String
  ) {
    when (input) {
      "." -> {
        if (input !in currentNumber) {
          currentNumber += (if (currentNumber.isEmpty()) "0." else ".")
        }
      }

      "0" -> {
        if (currentNumber.isNotEmpty()) {
          currentNumber += input
        }
      }

      else -> {
        currentNumber += input
      }
    }
  }

  override fun reset() {

  }
}