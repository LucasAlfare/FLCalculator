package com.lucasalfare.flcalculator.core

import com.lucasalfare.flcalculator.core.fsm.NumberState
import com.lucasalfare.flcalculator.core.fsm.ParsingState

class CalculatorState {

  var state = ""
  private var currentParsingState: ParsingState = NumberState()

  fun handleInput(s: String) {
    if (s != " ") {
      runCatching {
        currentParsingState = currentParsingState.handleInput(s)!!
        currentParsingState.update(s) { state += it }
      }
    }
  }
}