package com.example.gravitocmpwebviewandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNavigate: Button = findViewById(R.id.buttonNavigate)
        buttonNavigate.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val buttonClearKey: Button = findViewById(R.id.buttonClearKey)
        buttonClearKey.setOnClickListener {
            clearKeyFromSharedPreferences("GCString")
        }
    }

    private fun clearKeyFromSharedPreferences(key: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }
}