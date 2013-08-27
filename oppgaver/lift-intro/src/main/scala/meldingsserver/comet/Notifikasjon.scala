package meldingsserver.comet

import net.liftweb.http.{CometActor, CometListener}

/** @author tommyskodje */

class Notifikasjon extends CometActor with CometListener {

  private var sisteMelding = ""
  def render = "#notifikasjon *" #> sisteMelding
  protected def registerWith = NotifikasjonsServer
  override def lowPriority = {
  case Melding(m) =>
  sisteMelding = m
  reRender()
  }
}