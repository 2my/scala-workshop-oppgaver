package meldingsserver.snippet

/** @author tommyskodje */

import net.liftweb.util.Helpers._
import net.liftweb.http._

object Login extends DispatchSnippet {

  object LoggedIn extends SessionVar[Boolean](false)

  def dispatch = {
    case "login" => login
  }

  def login = {
    var userid = ""
    var password = ""
    def resultat() = S.redirectTo(
      "/index",
      () => LoggedIn( userid == password )
    )

   "@userid" #> SHtml.text( "", userid = _ ) &
   "@password" #> SHtml.text( "", password = _ ) &
   ":submit" #> SHtml.onSubmitUnit(resultat)
  }

}
