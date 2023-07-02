package selenium_example

import wvlet.airspec.AirSpec
import org.scalajs.dom

class MainUITest extends AirSpec {
  test("render main UI") {
    MainUI.renderMain()

    val elem = dom.document.getElementById("ui-title")
    elem shouldNotBe null
    elem.innerHTML shouldContain "Hello Scala.js + Selenium"
  }
}
