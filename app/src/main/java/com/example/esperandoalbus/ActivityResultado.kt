package com.example.esperandoalbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ActivityResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val bundle = intent.extras
        val nombreUsuario  = bundle?.getString("usuario")
        val numUsuario     = bundle?.getInt("numUsuario")
        var numCorrecto    = bundle?.getInt("numCorrecto")
        var numeroIntentos = bundle?.getInt("intentos")
        var record         = bundle?.getInt("record")

        val n1             = numUsuario.toString().toInt()
        val n2             = numCorrecto.toString().toInt()
        val resultTxV      = findViewById<TextView>(R.id.mensaTxV)
        val intentarTxV    = findViewById<Button>(R.id.volverIntentoBtn)
        val volverA2    = findViewById<Button>(R.id.volverAc2Btn)
        intentarTxV.isEnabled = true

        if (n1 == n2) {
            resultTxV.setText("ENHORABUENA " + nombreUsuario.toString() + "\n HAS ACERTADO\n El número elegido es el " + n1)
            numeroIntentos = numeroIntentos!! + 1

            if (numeroIntentos < record!!) {
                Toast.makeText(this,"¡¡¡Conseguiste un nuevo record!!!", Toast.LENGTH_LONG).show()
                record = numeroIntentos
            }
            numeroIntentos = 0
            intentarTxV.isEnabled = false
            numCorrecto = (Math.random()*10).toInt()
        }

        else {
            if (n1 < n2) {
                resultTxV.setText("LO SIENTO " + nombreUsuario.toString() +  "\n EL NÚMERO MISTERIOSO ES MÁS ALTO")
            } else{
                resultTxV.setText("LO SIENTO " + nombreUsuario.toString() +  "\n EL NÚMERO MISTERIOSO ES MÁS BAJO")
            }
            numeroIntentos = numeroIntentos!! + 1
        }
        intentarTxV.setOnClickListener {

            val intento = Intent(this, ActivityJuego::class.java)
            intento.putExtra("usuario",nombreUsuario.toString())
            intento.putExtra("intentos",numeroIntentos)
            intento.putExtra("numCorrecto",numCorrecto)
            intento.putExtra("record",record)
            startActivity(intento)
        }
        volverA2.setOnClickListener {
            val intento = Intent(this, ActivityJuego::class.java)
            intento.putExtra("usuario",nombreUsuario.toString())
            intento.putExtra("intentos",numeroIntentos)
            intento.putExtra("numCorrecto",numCorrecto)
            intento.putExtra("record",record)
            startActivity(intento)
        }
    }
}