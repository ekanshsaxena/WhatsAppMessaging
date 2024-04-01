import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import kotlinx.coroutines.*

fun main(args: Array<String>) {
    runBlocking{
        launch {
            whatsappNotification("<Phone number added on Twilio>")
        }
    }
}

fun whatsappNotification(phone: String){
    val accountSid = "<Account SID>"
    val authToken = "<Auth Token>"

    Twilio.init(accountSid, authToken)

    val from = PhoneNumber("whatsapp:+14155238886") // Your Twilio WhatsApp number
    val to = PhoneNumber("whatsapp:$phone") // Recipient's WhatsApp number

    val message = Message.creator(
        to,
        from,
        "Hello Traveler, Please go to Virtual Agent given on trips Page to raise your Query !!!"
    ).create()

    println("Message sent with SID: ${message.sid}")
}
