package DemoApplication

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Label

object demo extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "DemoApp"
    scene = new Scene(600, 400) {
      val label = new Label {
        text = "HELLO"
        layoutX = 100
        layoutY = 100
       
        
      }
      content = List(label)
    }
  }
}