package com.example.esperandoalbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class activity_juego2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego2)

        val bundle = this.intent.extras

        val nombreUsuario = bundle?.getString("usuario")
        val tvU = findViewById<TextView>(R.id.tvUser)
        var tvPunU   = findViewById<TextView>(R.id.tvPunUser)
        var tvPunCPU = findViewById<TextView>(R.id.tvPunCPU)
        var tvElUser = findViewById<TextView>(R.id.tvEleUser)
        var tvElCPU = findViewById<TextView>(R.id.tvEleCPU)
        val btPiedra = findViewById<Button>(R.id.btPiedra)
        val btPapel = findViewById<Button>(R.id.btPapel)
        val btTijera = findViewById<Button>(R.id.btTijera)
        val btSalir = findViewById<Button>(R.id.btSalir)

        var puntuacionUser = 0;
        var puntuacionCPU  = 0;
        tvU.text = nombreUsuario.toString().uppercase()
        tvPunU.text = puntuacionUser.toString()
        tvPunCPU.text = puntuacionCPU.toString()

        var numCPU = 0
        var numUser = 0
        btPiedra.setOnClickListener {
            tvElUser.text = btPiedra.text
            numUser = 1
            numCPU = ((Math.random()*3)+1).toInt()
            tvElCPU.text = textoCPU(numCPU)

            //Comprobar ganador
            when (numCPU) {
                1 -> {
                    tvElUser.text = "EMPATE"
                    tvElCPU.text = "EMPATE"
                }
                2 ->{
                    tvElUser.text = "PERDEDOR"
                    tvElCPU.text = "GANADOR"
                    puntuacionCPU++
                }

                3 ->{
                    tvElUser.text = "GANADOR"
                    tvElCPU.text = "PERDEDOR"
                    puntuacionUser++
                }
            }
            tvPunU.text = puntuacionUser.toString()
            tvPunCPU.text = puntuacionCPU.toString()
        }//Fin botón piedra
        btPapel.setOnClickListener {
            tvElUser.text = btPapel.text
            numUser = 2
            numCPU = ((Math.random()*3)+1).toInt()
            tvElCPU.text = textoCPU(numCPU)

            //Comprobar ganador
            when (numCPU) {
                1 -> {
                    tvElUser.text = "GANADOR"
                    tvElCPU.text = "PERDEDOR"
                    puntuacionUser++
                }
                2 ->{
                    tvElUser.text = "EMPATE"
                    tvElCPU.text = "EMPATE"
                }

                3 ->{
                    tvElUser.text = "PERDEDOR"
                    tvElCPU.text = "GANADOR"
                    puntuacionCPU++
                }
            }
            tvPunU.text = puntuacionUser.toString()
            tvPunCPU.text = puntuacionCPU.toString()

        }//Fin botón papel
        btTijera.setOnClickListener {
            tvElUser.text = btTijera.text
            numUser = 3
            numCPU = ((Math.random()*3)+1).toInt()
            tvElCPU.text = textoCPU(numCPU)

            //Comprobar ganador
            //Comprobar ganador
            when (numCPU) {
                1 -> {
                    tvElUser.text = "PERDEDOR"
                    tvElCPU.text = "GANADOR"
                    puntuacionCPU++
                }
                2 ->{
                    tvElUser.text = "GANADOR"
                    tvElCPU.text = "PERDEDOR"
                    puntuacionUser++
                }

                3 ->{
                    tvElUser.text = "EMPATE"
                    tvElCPU.text = "EMPATE"
                }
            }
            tvPunU.text = puntuacionUser.toString()
            tvPunCPU.text = puntuacionCPU.toString()
        }//Fin botón tijera
        btSalir.setOnClickListener{
            val intento = Intent(this, Pricipal::class.java)
            startActivity(intento)
        }
    }
    fun textoCPU(numCPU: Int) : String {
        var movimiento = ""
        when (numCPU) {
            1 -> movimiento = "PIEDRA"
            2 -> movimiento = "PAPEL"
            3 -> movimiento = "TIJERA"
        }
        return movimiento
    }
}