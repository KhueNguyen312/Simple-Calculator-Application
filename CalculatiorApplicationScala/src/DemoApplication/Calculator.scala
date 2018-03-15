package DemoApplication

import scalafx.application.JFXApp
import scalafx.scene.control._
import scalafx.scene.Scene
import scalafx.event.ActionEvent
import scalafx.Includes._
import javax.swing.text.Style
import scalafx.scene.text.Font
import javax.swing.GroupLayout.Alignment
import javax.swing.text.StyledEditorKit.AlignmentAction
import scalafx.delegate.AlignmentDelegate
import scalafx.geometry.Pos
import scala.collection.mutable.Stack
import scala.collection.mutable.StringBuilder
import scalafx.scene.paint.Color
import javafx.scene.paint.Color


object Calculator extends JFXApp {
  var nums = 0.0; var ans = 0.0; var count = 0;
  stage = new JFXApp.PrimaryStage {
    title = "Calculator ver 1.0"
    
    scene = new Scene(390, 480) {
      
      val displayX = 20
      val displayY = 25
      val display = new TextField {
        alignment = Pos.CENTER_RIGHT
        prefHeight = 50
        prefWidth = 350
        editable = false
        layoutX = displayX
        layoutY = displayY
      }
      display.font = Font.font(20)
      val label = new Label{
        text = ""
        layoutX = displayX +5
        layoutY = displayY 
        
      }

      // Button
      val buttonHeight = 40
      val buttonWidth = 75
      val Button1 = new Button("OFF")
      Button1.setBackground(Color.)

      SetButtonPosAndSize(Button1, displayX, displayY + 100, buttonHeight, buttonWidth)

      val Button2 = new Button("<--")
      SetButtonPosAndSize(Button2, displayX + 90, displayY + 100, buttonHeight, buttonWidth)

      val Button3 = new Button("Clear")
      SetButtonPosAndSize(Button3, displayX + 180, displayY + 100, buttonHeight, buttonWidth)

      val Button4 = new Button("+")
      SetButtonPosAndSize(Button4, displayX + 270, displayY + 100, buttonHeight, buttonWidth)

      val Button5 = new Button("7")
      SetButtonPosAndSize(Button5, displayX, displayY + 170, buttonHeight, buttonWidth)

      val Button6 = new Button("8")
      SetButtonPosAndSize(Button6, displayX + 90, displayY + 170, buttonHeight, buttonWidth)

      val Button7 = new Button("9")
      SetButtonPosAndSize(Button7, displayX + 180, displayY + 170, buttonHeight, buttonWidth)

      val Button8 = new Button("-")
      SetButtonPosAndSize(Button8, displayX + 270, displayY + 170, buttonHeight, buttonWidth)

      val Button9 = new Button("4")
      SetButtonPosAndSize(Button9, displayX, displayY + 240, buttonHeight, buttonWidth)

      val Button10 = new Button("5")
      SetButtonPosAndSize(Button10, displayX + 90, displayY + 240, buttonHeight, buttonWidth)

      val Button11 = new Button("6")
      SetButtonPosAndSize(Button11, displayX + 180, displayY + 240, buttonHeight, buttonWidth)

      val Button12 = new Button("*")
      SetButtonPosAndSize(Button12, displayX + 270, displayY + 240, buttonHeight, buttonWidth)

      val Button13 = new Button("1")
      SetButtonPosAndSize(Button13, displayX, displayY + 310, buttonHeight, buttonWidth)

      val Button14 = new Button("2")
      SetButtonPosAndSize(Button14, displayX + 90, displayY + 310, buttonHeight, buttonWidth)

      val Button15 = new Button("3")
      SetButtonPosAndSize(Button15, displayX + 180, displayY + 310, buttonHeight, buttonWidth)

      val Button16 = new Button("/")
      SetButtonPosAndSize(Button16, displayX + 270, displayY + 310, buttonHeight, buttonWidth)

      val Button17 = new Button("0")
      SetButtonPosAndSize(Button17, displayX, displayY + 380, buttonHeight, buttonWidth)

      val Button18 = new Button(".")
      SetButtonPosAndSize(Button18, displayX + 90, displayY + 380, buttonHeight, buttonWidth)

      val Button19 = new Button("=")
      SetButtonPosAndSize(Button19, displayX + 180, displayY + 380, buttonHeight, buttonWidth * 2 + 16.5)

      val Button20 = new Button("ON")
      SetButtonPosAndSize(Button20, displayX, displayY + 100, buttonHeight, buttonWidth)
      Button20.visible = false

      //Event

      Button1.onAction = (event: ActionEvent) => {
        Button1.visible = false //OFF
        Button20.visible = true // ON
        Button2.disable = true
        Button3.disable = true
        Button4.disable = true
        Button5.disable = true
        Button6.disable = true
        Button7.disable = true
        Button8.disable = true
        Button9.disable = true
        Button10.disable = true
        Button11.disable = true
        Button12.disable = true
        Button13.disable = true
        Button14.disable = true
        Button15.disable = true
        Button16.disable = true
        Button17.disable = true
        Button18.disable = true
        Button19.disable = true
        label.text = ""
        display.text = ""
        ans = 0
        nums = 0
      }
      Button20.onAction = (event: ActionEvent) => {
        Button1.visible = true
        Button20.visible = false
        Button2.disable = false
        Button3.disable = false
        Button4.disable = false
        Button5.disable = false
        Button6.disable = false
        Button7.disable = false
        Button8.disable = false
        Button9.disable = false
        Button10.disable = false
        Button11.disable = false
        Button12.disable = false
        Button13.disable = false
        Button14.disable = false
        Button15.disable = false
        Button16.disable = false
        Button17.disable = false
        Button18.disable = false
        Button19.disable = false
      }
      //Input function
      Button2.onAction = (event: ActionEvent)=>{
        Delete()
      }
      Button3.onAction = (event: ActionEvent) => {
        display.text = ""
        label.text = ""
        ans = 0
        nums = 0
      }
      Button4.onAction = (event: ActionEvent) => {
        OperatorClicked()
        count = 1
        label.text = nums.toString() + "+"
      }
      Button5.onAction = (event: ActionEvent) => {
        display.text = display.getText + "7"
        if(label != null)
          Calculate()
      }

      Button6.onAction = (event: ActionEvent) => {
        display.text = display.getText + "8"
      }
      Button7.onAction = (event: ActionEvent) => {
        display.text = display.getText + "9"
      }
      Button8.onAction = (event: ActionEvent) => {
        OperatorClicked()
        count = 2
        label.text = nums.toString() + "-"
      }
      Button9.onAction = (event: ActionEvent) => {
        display.text = display.getText + "4"
      }
      Button10.onAction = (event: ActionEvent) => {
        display.text = display.getText + "5"
      }
      Button11.onAction = (event: ActionEvent) => {
        display.text = display.getText + "6"
      }
      Button12.onAction = (event: ActionEvent) => {
        OperatorClicked()
        count = 3
        label.text = nums.toString() + "x"
      }
      Button13.onAction = (event: ActionEvent) => {
        display.text = display.getText + "1"
      }
      Button14.onAction = (event: ActionEvent) => {
        display.text = display.getText + "2"
      }
      Button15.onAction = (event: ActionEvent) => {
        display.text = display.getText + "3"
      }
      Button16.onAction = (event: ActionEvent) => {
        OperatorClicked()
        count = 4
        label.text = nums.toString() + "/"
      }
      Button17.onAction = (event: ActionEvent) => {
        display.text = display.getText + "0"
      }
      Button18.onAction = (event: ActionEvent) => {
        if(!display.getText.contains("."))
          display.text = display.getText + "."
      }
      Button19.onAction = (event: ActionEvent) => {
        Calculate()
        label.text = "" 
      }
      //Calculation
      def OperatorClicked()={
        if(nums != 0)
        {
           Calculate() 
        }
        else
        {
          nums = display.getText.toString().toFloat
        }
        display.clear()
        
      }
      def Calculate():Unit={
      count match
      {
        case 1 => ans = nums + display.getText.toString().toFloat
                  display.text = ans.toString()
        case 2 => ans = nums - display.getText.toString().toFloat
                  display.text = ans.toString()
        case 3 => ans = nums * display.getText.toString().toFloat
                  display.text = ans.toString()
        case 4 => ans = nums / display.getText.toString().toFloat
                  display.text = ans.toString()
      }
      nums = ans
    }
      def Delete()={
        var lenght =display.getText.length()-1
        var text = display.getText
        var i = 0
        display.clear()
        for(i<- 1 to lenght)
          display.text = display.getText + text(i)
      }
      //Add all controls to Application
      content = List(display, Button1, Button2, Button3, Button4, Button5,
        Button6, Button7, Button8, Button9, Button10,
        Button11, Button12, Button13, Button14, Button15, Button16, Button17, Button18, Button19, Button20,label)
        
    
  }
  private def SetButtonPosAndSize(btn: Button, posX: Double, posY: Double, height: Double, width: Double): Unit = {
    btn.layoutX = posX
    btn.layoutY = posY
    btn.minHeight = height
    btn.minWidth = width
  }
  
  
}
}