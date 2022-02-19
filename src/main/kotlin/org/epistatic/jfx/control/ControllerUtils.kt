package org.epistatic.jfx.control

import javafx.fxml.FXMLLoader
import javafx.scene.layout.Pane

class FXMLForm(val pane: Pane, val controller: Any)

fun load(path: String): Pane {
    val loader = FXMLLoader(FXMLForm::class.java.getResource(path))
    val pane = loader.load<Pane>()
    return pane
}

fun loadWithController(path: String): FXMLForm {
    val loader = FXMLLoader(FXMLForm::class.java.getResource(path))
    return FXMLForm(loader.load(), loader.getController())
}

fun loadWithController(path: String, controller: Any): Pane {
    val loader = FXMLLoader(FXMLForm::class.java.getResource(path))
    loader.setController(controller)
    return loader.load()
}
