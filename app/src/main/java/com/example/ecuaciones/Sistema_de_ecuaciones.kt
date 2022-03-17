package com.example.ecuaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class Sistema_de_ecuaciones : AppCompatActivity() {




    private fun calcularX(){


    }

    private fun calcularY(){


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sistema_de_ecuaciones)

        val a1 = findViewById<EditText>(R.id.a1)
        val a2 = findViewById<EditText>(R.id.a2)
        val b1 = findViewById<EditText>(R.id.b1)
        val b2 = findViewById<EditText>(R.id.b2)
        val c1 = findViewById<EditText>(R.id.c1)
        val c2 = findViewById<EditText>(R.id.c2)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val respuestaX = findViewById<TextView>(R.id.RX)
        val respuestaY = findViewById<TextView>(R.id.RY)



        btnCalcular.setOnClickListener {

            val varA1 = (a1.getText().toString()).toDouble()
            val varA2 = (a2.getText().toString()).toDouble()

            val varB1 = (b1.getText().toString()).toDouble()
            val varB2 = (b2.getText().toString()).toDouble()

            val varC1 = (c1.getText().toString()).toDouble()
            val varC2 = (c2.getText().toString()).toDouble()


            val x = (varC1*varB2 - varC2*varB1)/(varA1*varB2 - varA2*varB1)
            val y = (varA1*varC2 - varA2*varC1)/(varA1*varB2 - varA2*varB1)

            if((varA1*varB2 - varA2*varB1) != 0.0){
                val resX = x.toString()
                val resY = y.toString()

                respuestaX.setText("X = "+resX)
                respuestaY.setText("Y = "+resY)
            }else{
                respuestaX.setText("X no tiene solución")
                respuestaY.setText("Y no tiene solución")
            }




        }


    }
}