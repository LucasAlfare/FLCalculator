package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking

class OperationState : ParsingState {

  override fun handleInput(input: String): ParsingState? {
    return when {
      InputChecking.isNumeric(input) || InputChecking.isDot(input) -> NumberState()
      InputChecking.isOpenningAssociative(input) -> OpenningAssociativeState()

      else -> null
    }
  }

  override fun update(
    input: String,
    onStateUpdate: (String, Boolean) -> Unit
  ) {
    onStateUpdate(input, false)
  }
}