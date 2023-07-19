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
    val input1 = "4 * ((9 + 1) / 0.7)"
  }

  @Test
  fun `test multiple associatives`() {
    val input = "2 * (((90 - 0.04) + 1) + 2) / 89.08"
  }
}