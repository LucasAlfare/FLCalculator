package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking

class ClosingAssociativeState: ParsingState {

  private var nClosed = 0

  override fun handleInput(input: String): ParsingState? {
    return when {
      InputChecking.isClosingAssociative(input) -> {
        //special condition to transit this to itself
        if (nClosed + 2 == nOpenned) null else this
      }

      InputChecking.isOperator(input) -> OperationState()

      else -> null
    }
  }

  override fun update(
    input: String,
    onStateUpdate: (String, Boolean) -> Unit
  ) {
    nClosed++
    onStateUpdate(input, false)
  }
}