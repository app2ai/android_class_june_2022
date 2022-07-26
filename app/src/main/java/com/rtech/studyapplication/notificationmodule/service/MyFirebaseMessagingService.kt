package com.rtech.studyapplication.notificationmodule.service

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService(){
    // install / clear cache / 10-15 days
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        sendRegistrationToServer(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("TAG", "From: ${message.from}")

        message.data.let {
            Log.d("TAG", "Message data payload: " + message.data)
        }

        message.notification?.let {
            Log.d("TAG", "Message Notification Body: ${it.body}")
            sendNotification(it.body!!)
        }
    }

    private fun sendNotification(body: String) {
        val notificationManager = ContextCompat.getSystemService(applicationContext, NotificationManager::class.java) as NotificationManager
        // notificationManager.sendNotification(body, applicationContext)
    }

    private fun sendRegistrationToServer(token: String){
        // Can store on API server
    }

}