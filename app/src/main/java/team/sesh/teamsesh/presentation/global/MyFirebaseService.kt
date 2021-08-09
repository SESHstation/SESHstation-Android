package team.sesh.teamsesh.presentation.global


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.jetbrains.anko.notificationManager
import team.sesh.teamsesh.MainActivity
import team.sesh.teamsesh.R


class MyFirebaseService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String?) {
        Log.d(TAG, "sendRegistrationTokenToServer($token)")
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: ${remoteMessage.notification}")
        // Check if message contains a data payload.
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)
        }
        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }
        if (remoteMessage.notification != null) {
            sendNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
        }
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


    private fun sendNotification(title: String?, body: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )
        val stringBuilder = StringBuilder()
        stringBuilder.append("android.resource://")
        stringBuilder.append(this.getPackageName())
        stringBuilder.append("/")
        stringBuilder.append(R.raw.sesh)
        val uri = Uri.parse(stringBuilder.toString() as String)
        val channelId = getString(R.string.default_notification_channel_id)
        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setSmallIcon(R.drawable.seshskull_site)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(soundUri)
            .setContentIntent(pendingIntent)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                "SESH",
                NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }

    companion object {
        private const val TAG = "MyFirebaseService"
    }

}

//if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            mChannel = NotificationChannel(
//                channelId,
//                Utils.channelName,
//                NotificationManager.IMPORTANCE_HIGH
//            )
//            val channel = NotificationChannel(
//                channelId,
//                "SESH",
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            val audioAttributes = AudioAttributes.Builder()
//                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                .build()
//
//            channel.setSound(customSound, audioAttributes)
//            channel.enableLights(true)
//            channel.lightColor
//            notificationManager.createNotificationChannel(channel)
//}