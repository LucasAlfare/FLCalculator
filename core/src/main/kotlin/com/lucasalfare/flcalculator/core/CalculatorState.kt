package com.lucasalfare.flcalculator.core

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.lucasalfare.flcalculator.core.fsm.NumberState
import com.lucasalfare.flcalculator.core.fsm.ParsingState


data class CalculatorToken(var value: String = "", var isNumeric: Boolean = false)


class CalculatorState {

  private var stateTokens = mutableListOf<CalculatorToken>()
  private var currentParsingState: ParsingState = NumberState()
  private var result = ""

  fun handleInput(s: String) {
    if (s != " ") {
      // handles the state tokens building
      if (s !in "=C<") {
        currentParsingState = currentParsingState.handleInput(s)!!
        currentParsingState.update(s) { value, isNumeric ->
          if (isNumeric) {
            val last = stateTokens.lastOrNull()
            if (last != null && last.isNumeric) {
              last.value = value
            } else {
              stateTokens += CalculatorToken(value, true)
            }
          } else {
            stateTokens += CalculatorToken(value, false)
          }
        }
      } else {
        // handles the state tokens changes
        when (s) {
          "=" -> {
            calculateResult()
          }
          "C" -> {
            stateTokens.clear()
            result = ""
            currentParsingState = NumberState()
          }
          "<" -> {
            if (stateTokens.isNotEmpty()) {
              val last = stateTokens.last()
              if (last.isNumeric) {
                if (last.value.isNotEmpty()) {
                  last.value = last.value.slice(
                    0 until last.value.length - 1
                  )

                  currentParsingState = NumberState(last.value)

                  if (last.value.isEmpty()) stateTokens.removeLast()
                }
              } else {
                stateTokens.removeLast()
              }
            }

            result = ""
          }
        }
      }
    }
  }

  fun calculateResult() {
    var rawExpression = ""
    stateTokens.forEach { rawExpression += it.value }
    result = "123456789"
  }

  fun toAnnotatedString() = buildAnnotatedString {
    if (result.isEmpty()) {
      stateTokens.forEach {
        val nextStyle = if (it.isNumeric) {
          SpanStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Black
          )
        } else {
          SpanStyle(
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color(0xff7332a8)
          )
        }

        withStyle(nextStyle) {
          append(it.value)
        }
      }
    } else {
      append(result)
    }
  }
}