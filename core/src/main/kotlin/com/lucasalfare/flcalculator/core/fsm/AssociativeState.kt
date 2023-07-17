package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking

//TODO: differ between opening and closing associatives
class AssociativeState: ParsingState {
  override fun handleInput(input: String): ParsingState? {
    return when {
      InputChecking.isNumeric(input) || InputChecking.isDot(input) -> NumberState()
      else -> null
    }
  }

  override fun update(input: String, onStateUpdate: (String) -> Unit) {
    onStateUpdate(input)
  }
}