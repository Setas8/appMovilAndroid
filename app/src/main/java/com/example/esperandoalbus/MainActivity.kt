package com.example.esperandoalbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt = findViewById<Button>(R.id.btnInicio)

        bt.setOnClickListener {

            val intento = Intent(this, Pricipal::class.java)
            startActivity(intento)
        }
    }
}