package org.epistatic.number

import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import java.text.DecimalFormat
import java.text.ParsePosition
import kotlin.math.pow
import kotlin.math.roundToInt


private val integerFormat = DecimalFormat("#")


fun Double.roundTo(numFractionDigits: Int): Double {
    val factor = 10.0.pow(numFractionDigits.toDouble())
    return (this * factor).roundToInt() / factor
}

fun Float.roundTo(numFractionDigits: Int): Float {
    val factor = 10.0f.pow(numFractionDigits.toFloat())
    return (this * factor).roundToInt() / factor
}


fun acceptIntegers(field: TextField) {
    field.textFormatter = TextFormatter<Any> { c: TextFormatter.Change ->
        if (c.controlNewText.isEmpty()) {
            c
        }
        integerFormat.isParseIntegerOnly = true
        val parsePosition = ParsePosition(0)
        val obj = integerFormat.parse(c.controlNewText, parsePosition)
        if (obj == null || parsePosition.index < c.controlNewText.length) {
            null // not a digit
        } else {
            c
        }
    }
}

fun acceptDoubles(field: TextField) {
    field.textFormatter = TextFormatter<Any> { c: TextFormatter.Change ->
        if (c.controlNewText.isEmpty()) {
            c
        }
        val parsePosition = ParsePosition(0)
        val obj = integerFormat.parse(c.controlNewText, parsePosition)
        if (obj == null || parsePosition.index < c.controlNewText.length) {
            null // not a digit
        } else {
            c
        }
    }
}

