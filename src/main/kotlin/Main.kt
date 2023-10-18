import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import kotlinx.coroutines.*

fun main(args: Array<String>) {
    runBlocking{
        launch {
            whatsappNotification("+918529116019")
        }
    }
}

fun whatsappNotification(phone: String){
    val accountSid = "AC4c74464b614c087e7850ab06ded8ddb1"
    val authToken = "2672f66a57c5f0896b4762a6bb480531"

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