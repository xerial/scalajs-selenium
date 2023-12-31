package selenium_example

import wvlet.airspec.AirSpec
import org.scalajs.dom

class MainUITest extends AirSpec {
  test("render main UI") {
    info("Rendering the main UI")
    MainUI.renderMain()

    warn("Checking the DOM element")
    val elem = dom.document.getElementById("ui-title")
    elem shouldNotBe null
    elem.innerHTML shouldContain "Hello Scala.js + Selenium"

    println("Completed DOM UI test")
  }
}
