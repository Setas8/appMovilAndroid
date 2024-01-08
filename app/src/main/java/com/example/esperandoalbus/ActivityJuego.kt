package com.example.esperandoalbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        val tv         = findViewById<TextView>(R.id.wellcomeTxV)
        val tvNombre   = findViewById<TextView>(R.id.txViNombre)
        val tvIntentos = findViewById<TextView>(R.id.TxViIntentos)
        val tvRecord   = findViewById<TextView>(R.id.TxVIRecord)

        val bundle = this.intent.extras

        val nombreUsuario = bundle?.getString("usuario")
        var numIntentos   = bundle?.getInt("intentos")
        var record        = bundle?.getInt("record")
        var numCorrecto   = bundle?.getInt("numCorrecto")

        tv.text         = nombreUsuario.toString().uppercase() + ", EL NÚMERO MISTERIOSO ES DEL 1 AL 100"
        tvNombre.text   = "Jugador:   "  + nombreUsuario.toString().uppercase()
        tvIntentos.text = "Intentos: "   + numIntentos.toString()
        if (record == Integer.MAX_VALUE)
            tvRecord.text = "Record: "     + " NO HAY RECORD REGISTRADO"
        else
            tvRecord.text = "Record: "     + record.toString()
        val num     = findViewById<EditText>(R.id.numEdTx)
        val salirBt = findViewById<Button>(R.id.salirBtn)
        val contBt  = findViewById<Button>(R.id.contBtn)

        salirBt.setOnClickListener {
            val intento = Intent(this, Pricipal::class.java)
            intento.putExtra("record",record)
            startActivity(intento)
        }
        contBt.setOnClickListener {

            if (num.text.isEmpty())
                Toast.makeText(this,"NO INTRODUJISTE NINGÚN NÚMERO", Toast.LENGTH_LONG).show()
            else {
                val numero = num.text.toString().toInt()
                val intento = Intent(this, ActivityResultado::class.java)

                intento.putExtra("usuario",nombreUsuario.toString())
                intento.putExtra("numUsuario",numero)
                intento.putExtra("numCorrecto",numCorrecto)
                intento.putExtra("intentos",numIntentos)
                intento.putExtra("record",record)
                startActivity(intento)
            }
            num.text.clear()
        }
    }
}