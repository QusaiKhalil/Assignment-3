package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message = intent.getStringExtra("KEY")
        val textView= findViewById<TextView>(R.id.textView).apply {
            text= message
        }

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("KEY")
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        }
    }
}