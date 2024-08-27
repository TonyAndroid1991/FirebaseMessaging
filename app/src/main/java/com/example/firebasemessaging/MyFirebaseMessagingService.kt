package com.example.firebasemessaging

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

//        // Verifica si el mensaje contiene datos
//        remoteMessage.data.isNotEmpty().let {
//            Toast.makeText(this, "Contiene datos ", Toast.LENGTH_SHORT).show()
//
//        }
//
//        // Verifica si el mensaje contiene una notificación
//        remoteMessage.notification?.let {
//            Toast.makeText(this, "Contiene una notificacion", Toast.LENGTH_SHORT).show()
//
//        }

        Log.i("TAGGED", "onMessageReceived called ")

        val intent = Intent(applicationContext, SecondActivity::class.java).apply {
            action = Intent.ACTION_VIEW
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)

    }

}