package com.lucasalfare.flcalculator.core

import com.lucasalfare.flcalculator.core.ui.display
import com.lucasalfare.fllistener.EventManageable


class CalculatorManager: EventManageable() {

  private var currentCalculatorState = CalculatorState()

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
      display = currentCalculatorState.toAnnotatedString()
    }

    if (event == AppEvent.TestingEvent) {
      println("yahoooo!!")
    }
  }
}