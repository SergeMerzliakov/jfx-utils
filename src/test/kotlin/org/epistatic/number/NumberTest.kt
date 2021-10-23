package org.epistatic.number

import java.io.*
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset

class NumberTest {

    @Test
    fun doubleRoundTo() {
        assertThat(100.123.roundTo(2)).isCloseTo(100.12, Offset.offset(0.001))
        assertThat(100.1975.roundTo(2)).isCloseTo(100.20, Offset.offset(0.001))
    }

    @Test
    fun floatRoundTo() {
        assertThat(100.123f.roundTo(2)).isCloseTo(100.12f, Offset.offset(0.001f))
        assertThat(100.1975f.roundTo(2)).isCloseTo(100.20f, Offset.offset(0.001f))
    }

}
