package selenium_example

import org.scalajs.dom
import wvlet.airframe.rx.html.*
import wvlet.airframe.rx.html.all.*

object MainUI:
  def main(args: Array[String]): Unit =
    renderMain()

  def renderMain(): Unit =
    val mainPanel = MainPanel()
    mainPanel.renderTo("main")

class MainPanel extends RxElement:
  def render: RxElement = div(
    id -> "ui-title",
    p("Hello Scala.js + Selenium")
  )
