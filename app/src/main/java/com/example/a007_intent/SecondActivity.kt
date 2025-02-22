package com.example.a007_intent

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_second)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

           var message = intent.getStringExtra("messageMy")
            findViewById<TextView>(R.id.textView2).text = "Hello, $message"

        findViewById<Button>(R.id.btnHome).setOnClickListener {
            //startActivity(Intent(this, MainActivity::class.java))

            //create alert dialog before finishing an activity
            AlertDialog.Builder(this)
                .setTitle("Exit Second Activity")
                .setMessage("Are you sure you want to exit?")
                //if user clicks yes
                .setPositiveButton("Yes") { _, _ ->
                    finish()    //close/destroy the current activity
                }
                //do nothing if user clicks no. No listener is defined
                .setNegativeButton("No"){_,_ ->
                    //display Toast message
                    Toast.makeText(this, "You clicked No.", Toast.LENGTH_LONG).show()
                }
                //handle neutral/cancel scenario
                .setNeutralButton("Later"){_,_ ->
                    //create snackbar to ask user to rethinks his/her decision
                    Snackbar.make(findViewById(R.id.main), "You chose Later.", Snackbar.LENGTH_INDEFINITE)
                         .setAction("OK"){
                             //do nothing
                             Toast.makeText(this, "Good that you prefer to remain here!", Toast.LENGTH_LONG).show()
                        }.show()
                }
                .show()




        }

    }
}