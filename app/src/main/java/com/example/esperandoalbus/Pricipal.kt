package com.example.esperandoalbus

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Pricipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pricipal)

        //Decidir el modo publico (desde otra aplicación, privado (sólo en esta aplicación)
        //Objeto que crea un fichero en modo preferencias de modo privado
        val sharedPreferences = getSharedPreferences("preferencia", Context.MODE_PRIVATE)
        //Editor con el que rercoge el dato var= variable val = constante
        var editor = sharedPreferences.edit()

        val btAdivinar = findViewById<Button>(R.id.adivinarBtn)
        val btPPT = findViewById<Button>(R.id.pptBtn)
        val user = findViewById<EditText>(R.id.nombreEdTx)
        var numCorrecto = ((Math.random()*100)+1).toInt()
        var numIntentos = 0
        var record = Integer.MAX_VALUE

        val bundle = this.intent.extras

        var record2 = bundle?.getInt("record")
        if (record2 != null)
            record = record2

        btAdivinar.setOnClickListener {

            if (user.text.isEmpty())
                Toast.makeText(this,"El USUARIO NO PUEDE ESTAR VACÍO", Toast.LENGTH_LONG).show()
            else {
                editor.putString("usuario",user.text.toString().lowercase())    //.apply con cada uno
                editor.putInt("intentos",numIntentos)  //.apply con cada uno
                //Guardarlo en el fichero
                editor.commit()
                val intento = Intent(this, ActivityJuego::class.java)
                intento.putExtra("usuario",user.text.toString())
                intento.putExtra("intentos",numIntentos)
                intento.putExtra("numCorrecto",numCorrecto.toInt())
                intento.putExtra("record",record.toInt())
                startActivity(intento)
            }
            user.text.clear()
        }
        btPPT.setOnClickListener {
            if (user.text.isEmpty())
                Toast.makeText(this,"El USUARIO NO PUEDE ESTAR VACÍO", Toast.LENGTH_LONG).show()
            else {
                editor.putString("usuario",user.text.toString().lowercase())
                editor.commit()
                val intento = Intent(this, activity_juego2::class.java)
                intento.putExtra("usuario",user.text.toString())
                startActivity(intento)
            }
            user.text.clear()
        }
    }
}