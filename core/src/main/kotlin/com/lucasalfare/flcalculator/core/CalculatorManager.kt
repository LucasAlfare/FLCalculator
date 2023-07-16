package com.lucasalfare.flcalculator.core

import com.lucasalfare.fllistener.EventManageable

class CalculatorManager: EventManageable() {

  init {
    initiated = true
  }

  override fun onInitiated() {

  }

  override fun onNotInitiated() {

  }

  override fun onEvent(event: Any, data: Any?, origin: Any?) {

  }
}