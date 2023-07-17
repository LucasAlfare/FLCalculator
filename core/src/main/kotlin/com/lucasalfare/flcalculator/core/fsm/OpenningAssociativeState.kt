package com.lucasalfare.flcalculator.core.fsm

import com.lucasalfare.flcalculator.core.InputChecking


var nOpenned = 0

class OpenningAssociativeState: ParsingState {

  init { nOpenned = 0 }

  override fun handleInput(input: String): ParsingState? {
    return when {
      InputChecking.isOpenningAssociative(input) -> this
      InputChecking.isNumeric(input) || InputChecking.isDot(input) -> NumberState()
      else -> null
    }
  }

  override fun update(input: String, onStateUpdate: (String) -> Unit) {
    nOpenned++
    onStateUpdate(input)
  }
}