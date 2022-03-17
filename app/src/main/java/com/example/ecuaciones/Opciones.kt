package com.example.ecuaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val sistema = findViewById<Button>(R.id.btnSistema)
        val cuad = findViewById<Button>(R.id.btnCuadratics)

        sistema.setOnClickListener {
            val intent = Intent(this,Sistema_de_ecuaciones::class.java)
            startActivity(intent)
        }

        cuad.setOnClickListener {
            val intent = Intent(this,EcuacionesCuadraticas::class.java)
            startActivity(intent)
        }
    }
}