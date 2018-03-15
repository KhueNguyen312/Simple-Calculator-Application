
package LearningGUIGraphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.MenuBar
import scalafx.scene.control.Menu
import scalafx.scene.control._
import scalafx.scene.layout._
import javafx.geometry.Orientation
import scalafx.scene.canvas.Canvas
import scalafx.event.ActionEvent


object Calculator extends JFXApp {
  private var drawings = List[Int]()
  
  stage = new JFXApp.PrimaryStage {
    title = "Calculator ver 1.0"
    scene = new Scene(400, 600) {
      val menubar = new MenuBar
      val file = new Menu("File")
      val newItem = new MenuItem("New item")
      val openItem = new MenuItem("Open item")
      val saveItem = new MenuItem("Save item")
      val exitItem = new MenuItem("Exit item")
      val edit = new Menu("Edit")
      file.items = List(newItem,openItem,saveItem,new SeparatorMenuItem,exitItem)
      menubar.menus = List(file, edit)
      
      val tabPane = new TabPane
      val firstDrawing: Int = 0
      drawings = drawings :+ firstDrawing
      tabPane += MakeDrawingTab(firstDrawing,"Untitled")
      //val drawing = new Drawing
      newItem.onAction = (ae: ActionEvent) =>{
        val newDrawing: Int = 0
        drawings = drawings :+ newDrawing
        val newTab = MakeDrawingTab(newDrawing,"Untitled")
        tabPane += newTab
      }
      exitItem.onAction = (ae: ActionEvent) => {
        sys.exit()
      }
      // Set vi tri cho menubar bang cach dung pane de thay vi content
      val rootPane = new BorderPane
      rootPane.top = menubar
      rootPane.center = tabPane
      root = rootPane
    }
  }
  private def MakeDrawingTab(drawing: Int, Name : String):Tab={
    val drawingTree = new TreeView[String]
    val treeScroll = new ScrollPane
    treeScroll.content = drawingTree
    val propertyPane = new ScrollPane
    val leftSplit = new SplitPane
    leftSplit.orientation = Orientation.VERTICAL
    leftSplit.items ++= List(treeScroll,propertyPane)
    
    val topRightBorder = new BorderPane
    val slider = new Slider(0,1000,0)
    val canvas = new Canvas
    topRightBorder.top = slider
    topRightBorder.center = canvas
    
    val bottomRightBorder = new BorderPane
    val commandField = new TextField
    val commandArea = new TextArea
    commandArea.editable = false
    bottomRightBorder.top = commandField
    bottomRightBorder.center = commandArea
    
    val rightSplit = new SplitPane
    rightSplit.orientation = Orientation.VERTICAL
    rightSplit.items ++= List(topRightBorder,bottomRightBorder)
    rightSplit.dividerPositions = 0.7
    
    val topSplit = new SplitPane
    topSplit.items ++= List(leftSplit,rightSplit) 
    topSplit.dividerPositions = 0.3
    
    val tab = new Tab
    tab.text = Name
    tab.content = topSplit
    tab
  }
}