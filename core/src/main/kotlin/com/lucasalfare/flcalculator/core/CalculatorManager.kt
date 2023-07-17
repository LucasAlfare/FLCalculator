package com.lucasalfare.flcalculator.core

import com.lucasalfare.flcalculator.core.ui.displayText
import com.lucasalfare.fllistener.EventManageable


class CalculatorManager: EventManageable() {

  var currentCalculatorState = CalculatorState()

  init {
    initiated = true
  }

  override fun onInitiated() {

  }

  override fun onNotInitiated() {

  }

  override fun onEvent(event: Any, data: Any?, origin: Any?) {
    if (event == AppEvent.Input) {
      val input = data as String
      currentCalculatorState.handleInput(input)
      displayText = currentCalculatorState.state
    }

    if (event == AppEvent.TestingEvent) {
      println("yahoooo!!")
    }
  }
}