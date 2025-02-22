package com.example.a007_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val btnActivity = findViewById<Button>(R.id.btnStartActivity)
        btnActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("messageMy", "Alien")
            startActivity(intent)
        }

        //implicit intent - > we request the default browser to open the given URI
        findViewById<Button>(R.id.btnWebsite).setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/search?q=android&source=hp&sca_esv=439224c42db21a77&oq=android&gs_l=mobile-heirloom-hp.3..0i512i433l5.7740.8696.0.8876.8.7.0.1.1.0.137.696.5j2.7.0....0...1.1.34.mobile-heirloom-hp..1.7.695.V6BN75mKm84&sei=9iu5Z_f9CPmZseMP7O3e2AE")
            )
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDial).setOnClickListener {
            //ACTION_DIAL is implicit intent
            //    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"))
            //ACTION_CALL is explicit intent
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:9662999992"))
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnMaps).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:1.27924,103.87105"))
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnShare).setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "This is my text to share")
            startActivity(intent)
        }

        //work with notification
        findViewById<Button>(R.id.btnNotification).setOnClickListener {

            showNotification()
        }

    }

    //channel is required if android version is API 26 or higher (Oreo)
    //channels are required for showing notifications in android 8.0 or higher
    //notification channels is used to group notification together.
    private val CHANNEL_ID = "my_channel_id"
    val NOTIFICATION_ID = 1     //unique ID for notification

    /*
    build and display notifcation with title, text and icon using
    Notification Compact Builder
     */
    private fun showNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("New notification")
            .setContentText("This is a new notification")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        //show notifcation
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())

    }
}