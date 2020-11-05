package org.epistatic.jfx.control

import javafx.event.EventHandler
import javafx.scene.control.Control
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.*;


/*
 * Invoke given function on loss of focus
 */
fun <T : Control> focusLostHandler(f: T, handler: (f: T) -> Unit) {
	f.focusedProperty()
			.addListener { _, _, hasFocus ->
				if (!hasFocus)
					handler(f)
			}
}


/**
 * Force a focus lost event on enter or tab key press
 */
class FocusHandler : EventHandler<KeyEvent> {
	override fun handle(e: KeyEvent?) {
		if (e?.code === KeyCode.ENTER) {
			val ctrl = e.source as Control
			val kids = ctrl.parent.childrenUnmodifiable
			val nextFocus = kids.indexOf(ctrl) + 1
			if (nextFocus < kids.size) {
				kids[nextFocus].requestFocus()
			}
		}
	}
}
