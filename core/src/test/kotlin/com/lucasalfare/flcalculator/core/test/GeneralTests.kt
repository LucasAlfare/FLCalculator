package com.lucasalfare.flcalculator.core.test

import com.lucasalfare.flcalculator.core.AppEvent
import com.lucasalfare.flcalculator.core.CalculatorManager
import com.lucasalfare.flcalculator.core.CalculatorState
import com.lucasalfare.fllistener.EventManageable
import com.lucasalfare.fllistener.setupManagers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.expect


internal class DummyManager: EventManageable() {

  init { initiated = true }

  override fun onInitiated() {
  }

  override fun onNotInitiated() {
  }

  override fun onEvent(event: Any, data: Any?, origin: Any?) {

  }
}

internal class GeneralTests {

  private val dummyManager = DummyManager()
  private val calculatorManager = CalculatorManager()

  init {
    CoroutineScope(Job()).launch {
      setupManagers(
        dummyManager,
        calculatorManager
      )
    }
  }

  @Test
  fun `test calculator manager event request`() {
    val outContent = ByteArrayOutputStream()
    System.setOut(PrintStream(outContent))
    dummyManager.notifyListeners(AppEvent.TestingEvent)

    assertEquals(
      expected = "yahoooo!!\n",
      actual = outContent.toString()
    )
  }

  @Test
  fun `test calculator state assembling`() {
    val input1 = "1 + 1 - 0.085 + 789.09 / 1.9 * (123.09 - 0.0017)"
    val targetState = CalculatorState()

    input1.forEach {
      targetState.handleInput("$it")
    }

    assertEquals(
      expected = "1+1-0.085+789.09/1.9*(123.09-0.0017)",
      actual = targetState.state
    )
  }
}