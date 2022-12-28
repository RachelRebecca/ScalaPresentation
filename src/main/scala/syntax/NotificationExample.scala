package syntax

object NotificationExample {
  sealed trait Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String =
    notification match {
      case Email(sender, title, _) => s"You got an email from $sender with title: $title"
      case SMS(number, message) => s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) => s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }

  def main(args: Array[String]): Unit = {
    val someSms: SMS = SMS("12345", "Are you there?")
    val someVoiceRecording: VoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))

    println(showNotification(someVoiceRecording))
  }
}
