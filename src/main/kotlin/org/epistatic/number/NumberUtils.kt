package org.epistatic.number

import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import java.text.DecimalFormat
import java.text.ParsePosition
import kotlin.math.pow
import kotlin.math.roundToInt

private val integerFormat = DecimalFormat("#")

// TODO fix - does not work for large values
fun Double.roundTo(numFractionDigits: Int): Double {
    val factor = 10.0.pow(numFractionDigits.toDouble())
    return (this * factor).roundToInt() / factor
}

// TODO fix - does not work for large values
fun Float.roundTo(numFractionDigits: Int): Float {
    val factor = 10.0f.pow(numFractionDigits.toFloat())
    return (this * factor).roundToInt() / factor
}

fun acceptIntegers(field: TextField) {
    field.textFormatter = TextFormatter<Any> { ch: TextFormatter.Change ->
        if (ch.controlNewText.isEmpty()) {
            ch
        }
        integerFormat.isParseIntegerOnly = true
        val parsePosition = ParsePosition(0)
        val obj = integerFormat.parse(ch.controlNewText, parsePosition)
        if (obj == null || parsePosition.index < ch.controlNewText.length) {
            null // not a digit
        } else {
            ch
        }
    }
}

fun acceptDoubles(field: TextField) {
    field.textFormatter = TextFormatter<Any> { ch: TextFormatter.Change ->
        if (ch.controlNewText.isEmpty()) {
            ch
        }
        val parsePosition = ParsePosition(0)
        val obj = integerFormat.parse(ch.controlNewText, parsePosition)
        if (obj == null || parsePosition.index < ch.controlNewText.length) {
            null // not a digit
        } else {
            ch
        }
    }
}

