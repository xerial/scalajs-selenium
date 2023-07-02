package selenium_example

import org.scalajs.dom
import wvlet.airframe.rx.html.*
import wvlet.airframe.rx.html.all.*

object MainUI:
  def main(args: Array[String]): Unit =
    renderMain()

  def renderMain(): Unit =
    // Insert main node if not exists
    val mainNode = dom.document.getElementById("main") match {
      case null =>
        val elem = dom.document.createElement("div")
        elem.setAttribute("id", "main")
        dom.document.body.appendChild(elem)
      case other => other
    }

    val mainPanel = MainPanel()
    DOMRenderer.renderTo(mainNode, mainPanel)


class MainPanel extends RxElement:
  def render: RxElement = div(
    id -> "ui-title",
    p("Hello Scala.js + Selenium")
  )

