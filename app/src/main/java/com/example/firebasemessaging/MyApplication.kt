package com.example.firebasemessaging

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Firebase.messaging.token.addOnCompleteListener {
            if (!it.isSuccessful) {
                return@addOnCompleteListener
            }

            val token = it.result
            Log.d("TAGGED", "Token: $token")
        }

        createNotificationChannel()
        subscribeToTopic()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "This is my channel"
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun subscribeToTopic() {
        Firebase.messaging.subscribeToTopic(WEATHER_TOPIC)
            .addOnCompleteListener { task ->
                var msg = "Subscribed to weather topic"
                if (!task.isSuccessful) {
                    msg = "Failed to subscribe to weather topic"
                    Log.d("TAGGED", msg)
                }
                Log.d("TAGGED", msg)
            }
    }

    companion object {
        const val CHANNEL_ID = "my_channel"
        const val CHANNEL_NAME = "my_channel"
        const val WEATHER_TOPIC = "weather"
    }
}