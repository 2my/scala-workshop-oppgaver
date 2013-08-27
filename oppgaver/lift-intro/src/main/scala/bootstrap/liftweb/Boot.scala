package bootstrap.liftweb

import net.liftweb.sitemap.{SiteMap, Menu}
import net.liftweb.common.Full
import net.liftweb.util.Helpers._
import meldingsserver.snippet._
import net.liftweb.http.{RedirectResponse, NoticeType, LiftRules}
import net.liftweb.sitemap.Loc.If

class Boot {

  def boot {
    val LoggedIn = If(
      () => Login.LoggedIn,
      () => RedirectResponse( "login" )
    )

    def sitemap = List(
      Menu("index") / "index" >> LoggedIn,
      Menu("login") / "login"
    )

    LiftRules.addToPackages("meldingsserver")

    LiftRules.setSiteMapFunc(() => SiteMap(sitemap: _*))

    LiftRules.noticesAutoFadeOut.default.set((noticeType: NoticeType.Value) => Full((2 seconds, 4 seconds)))
  }
}