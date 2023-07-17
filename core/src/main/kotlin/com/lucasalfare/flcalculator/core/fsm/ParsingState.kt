package com.lucasalfare.flcalculator.core.fsm

interface ParsingState {

  fun handleInput(input: String): ParsingState?

  fun update(input: String, onStateUpdate: (String) -> Unit)
}