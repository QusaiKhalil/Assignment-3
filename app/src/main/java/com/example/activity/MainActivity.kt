package com.example.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID="channelID"
    val CHANNEL_NAME="channelName"
    val NOTIFICATION_ID= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val button3 = findViewById<Button>(R.id.button3)

        button.setOnClickListener{
            val editText = findViewById<EditText>(R.id.ET)
            val message= editText.text.toString()

            val intent= Intent(this,MainActivity2::class.java).also{
                it.putExtra("KEY",message)
                startActivity(it)
            }
        }

        createNotificationChannel()
        val  notification= NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Assignment Notification")
            .setContentText("Notification have been sent AS A REMINDER")
            .setSmallIcon(R.drawable.ic_star_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        button3.setOnClickListener{
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }


    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.CYAN
                enableLights(true)

            }
            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}