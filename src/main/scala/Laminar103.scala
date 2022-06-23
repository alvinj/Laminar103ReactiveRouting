package alvin

import org.scalajs.dom
// import org.scalajs.dom.console
import com.raquo.laminar.api.L._

object Laminar103Routing extends App {

    val initialPage = "home"
    val currentPageVar = Var(initialPage)

    // i show home’s type so you can see it more easily
    val home: HtmlElement = div(
        h1("home"),
        button("login", 
            onClick --> (_ => currentPageVar.set("login")
    )))

    // login has the same type as home, but a great thing about
    // Scala is that you don’t have to declare the type if you
    // don’t want to
    val login = div(
        h1("login"),
        button("home",
            onClick --> (_ => currentPageVar.set("home")
    )))

    // here, rootElement consists of an outer div. then we change
    // the content inside that div based on the currentPageVar
    // signal. when the signal is "home", we show the home page,
    // and when the signal is "login", we show the login page.
    val rootElement = 
        div(
            cls := "outer-div",
            // this is where we change the content that’s inside
            // the outer div
            child <-- currentPageVar.signal.map {
                case "home" => home
                case "login" => login
            }
        )

    val appContainer = dom.document.querySelector("#root")
    render(appContainer, rootElement)

}


