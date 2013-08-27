package meldingsserver.comet

import net.liftweb.http.ListenerManager
import net.liftweb.actor.LiftActor

/** @author tommyskodje */

object NotifikasjonsServer extends LiftActor with ListenerManager {
  private var sisteMelding = Melding("Velkommen som lytter.")
  protected def createUpdate = sisteMelding
  override protected def lowPriority = {
    case m: Melding =>
    sisteMelding = m
    updateListeners()
  }

}