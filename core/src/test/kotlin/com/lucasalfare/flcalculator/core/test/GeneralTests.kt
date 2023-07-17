package com.lucasalfare.flcalculator.core.test

import com.lucasalfare.flcalculator.core.CalculatorManager
import com.lucasalfare.fllistener.EventManageable
import com.lucasalfare.fllistener.setupManagers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals


internal class AuxManager: EventManageable() {

  init { initiated = true }

  override fun onInitiated() {
  }

  override fun onNotInitiated() {
  }

  override fun onEvent(event: Any, data: Any?, origin: Any?) {

  }
}

internal class GeneralTests {

  private val auxManager = AuxManager()
  private val calculatorManager = CalculatorManager()

  init {
    CoroutineScope(Job()).launch {
      setupManagers(
        auxManager,
        calculatorManager
      )
    }
  }

  @Test
  fun `test calculator manager event request`() {
    val targetTestingEvent = "targetTestingEvent"
    val outContent = ByteArrayOutputStream()
    System.setOut(PrintStream(outContent))
    auxManager.notifyListeners(targetTestingEvent)
    assertEquals("yahoooo!!\n", outContent.toString())
  }
}