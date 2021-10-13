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

import javafx.scene.control.*
import kotlin.reflect.full.declaredMemberProperties

/**
 * Invoke given function on change of selection
 *
 * SelectionModel is not in any shared base class - all relevant controls just
 * have it as a member. Simpler to have a function for each rather than a generic
 * function.
 */
fun selectionChangedHandler(f: ComboBox<*>, handler: (f: ComboBox<*>) -> Unit) {
	f.selectionModel.selectedIndexProperty()
			.addListener { _, old, new ->
				if (old != new)
					handler(f)
			}
}

/**
 * SelectionModel is not in any shared base class - all relevant controls just
 * have it as a member. Simpler to have a function for each rather than a generic
 * function
 */
fun selectionChangedHandler(f: ListView<*>, handler: (f: ListView<*>) -> Unit) {
	f.selectionModel.selectedIndexProperty()
			.addListener { _, old, new ->
				if (old != new)
					handler(f)
			}
}

/**
 * SelectionModel is not in any shared base class - all relevant controls just
 * have it as a member. Simpler to have a function for each rather than a generic
 * function
 */
fun selectionChangedHandler(f: TableView<*>, handler: (f: TableView<*>) -> Unit) {
	f.selectionModel.selectedIndexProperty()
		.addListener { _, old, new ->
			if (old != new)
				handler(f)
		}
}

/**
 * SelectionModel is not in any shared base class - all relevant controls just
 * have it as a member. Simpler to have a function for each rather than a generic
 * function
 */
fun selectionChangedHandler(f: ChoiceBox<*>, handler: (f: ChoiceBox<*>) -> Unit) {
	f.selectionModel.selectedItemProperty()
			.addListener { _, old, new ->
				if (old != new)
					handler(f)
			}
}


/**
 * return selected items property name value or null if nothing selected
 */
fun <T : Any?> selectedItemProperty(model: MultipleSelectionModel<*>, propertyName: String): T? {
	if (model.isEmpty)
		return null

	val instance: Any = model.selectedItem as Any
	val clazz = instance.javaClass.kotlin
	@Suppress("UNCHECKED_CAST")
	return clazz.declaredMemberProperties.first { it.name == propertyName }.get(instance) as T
}
