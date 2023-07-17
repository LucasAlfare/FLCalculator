package com.lucasalfare.flcalculator.core

import com.lucasalfare.flcalculator.core.fsm.NumberState
import com.lucasalfare.flcalculator.core.fsm.ParsingState

class CalculatorState {

  private var currState: ParsingState = NumberState()

  fun handleInput(s: String) {
    if (s != " ") {
      currState = currState.handleInput(s)!!
      currState.update(s)
    }
  }
}