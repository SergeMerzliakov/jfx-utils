/*
 * Copyright 2020 Serge Merzliakov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.epistatic.jfx.control

import java.io.*
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.epistatic.jfx.control.cleanText

class FieldUtilsTest {

	@Test
	fun validString() {
		assertThat(cleanText("hello")).isEqualTo("hello")
	}

	@Test
	fun trimValidString() {
		assertThat(cleanText("   hello  ")).isEqualTo("hello")
	}

	@Test
	fun emptyString() {
		assertThat(cleanText("")).isEqualTo("")
	}


	@Test
	fun nullString() {
		assertThat(cleanText(null)).isEqualTo("")
	}

	@Test
	fun validInt() {
		assertThat(cleanInteger("1234")).isEqualTo(1234)
	}

	@Test
	fun trimValidInt() {
		assertThat(cleanInteger("   100  ")).isEqualTo(100)
	}

	@Test
	fun emptyInt() {
		assertThat(cleanInteger("")).isEqualTo(0)
	}

	@Test
	fun nullInt() {
		assertThat(cleanInteger(null)).isEqualTo(0)
	}
}
