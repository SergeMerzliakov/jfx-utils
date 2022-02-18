package org.epistatic.jfx.control

import javafx.scene.control.Control
import javafx.scene.layout.Region
import javafx.stage.Stage

fun stage(c: Region): Stage {
    return c.scene.window as Stage
}

fun closeWindow(c: Control) {
    val st = c.scene.window as Stage
    st.close()
}
