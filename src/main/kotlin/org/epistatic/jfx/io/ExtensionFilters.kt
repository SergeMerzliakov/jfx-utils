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
package org.epistatic.jfx.io

import javafx.stage.FileChooser

fun jsonFilter(): FileChooser.ExtensionFilter {
	return FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json")
}

fun jarFilter(): FileChooser.ExtensionFilter {
	return FileChooser.ExtensionFilter("Jar Files (*.jar)", "*.jar")
}

fun imageFilter(): FileChooser.ExtensionFilter {
	return FileChooser.ExtensionFilter("Image Files (png, jpeg, ico, icns)", "*.png", "*.jpeg", "*.jpg", "*.ico", "*.icns")
}
