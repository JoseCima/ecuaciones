package com.example.ecuaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class EcuacionesCuadraticas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuaciones_cuadraticas)



        val a1 = findViewById<EditText>(R.id.variableA)
        val b1 = findViewById<EditText>(R.id.variableB)
        val c1 = findViewById<EditText>(R.id.variableC)

        val btnCalcular = findViewById<Button>(R.id.btnCalcularCuadrado)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiarCuadrado)
        val respuestaX1 = findViewById<TextView>(R.id.respCuadratica)
        val respuestaX2 = findViewById<TextView>(R.id.respCuadratica2)
        val mostrarMensaje = findViewById<TextView>(R.id.mensajeCuadratica)
        val mostrarEc = findViewById<TextView>(R.id.mostrarCuadratica)



        fun limpiar(){
            respuestaX1.setText("")
            respuestaX2.setText("")
            mostrarMensaje.setText("")
            mostrarEc.setText("")

        }

        fun operaciones(varA1:Double, varB1:Double, varC1:Double){

            val x1 = (-varB1 + sqrt((varB1*varB1) - (4*varA1*varC1)))/(2*varA1)
            val x2 = (-varB1 - sqrt((varB1*varB1) - (4*varA1*varC1)))/(2*varA1)

            if((varB1*varB1 - 4*varA1*varC1) >= 0.0){
                val resX1 = x1.toString()
                val resX2 = x2.toString()



                if(x1 == x2){
                    limpiar()
                    respuestaX1.setText("Única solución: X = "+resX1)
                    mostrarMensaje.setText("Su ecuación cuadrática es:")
                    mostrarEc.setText("("+varA1.toInt()+")χ² + ("+varB1.toInt()+")χ + ("+varC1.toInt()+") = 0")
                }else{
                    limpiar()
                    respuestaX1.setText("X1 = "+resX1)
                    respuestaX2.setText("X2 = "+resX2)
                    mostrarMensaje.setText("Su ecuación cuadrática es:")
                    mostrarEc.setText("("+varA1.toInt()+")χ² + ("+varB1.toInt()+")χ + ("+varC1.toInt()+") = 0")
                }

            }else{
                limpiar()

                var determinante = ((varB1*varB1) - (4*varA1*varC1))
                val real = -varB1 / (2 * varA1)
                val complejo = sqrt(-determinante) /(2 * varA1)


                if(real == 0.0){
                    complejo.toString()
                    respuestaX1.setText("X1 = + ${complejo}i")
                    respuestaX2.setText("X2 = - ${complejo}i")
                    mostrarMensaje.setText("Su ecuación cuadrática es:")
                    mostrarEc.setText("("+varA1.toInt()+")χ² + ("+varB1.toInt()+")χ + ("+varC1.toInt()+") = 0")

                }else{
                    real.toString()
                    complejo.toString()
                    respuestaX1.setText("X1 = ${real} + ${complejo}i")
                    respuestaX2.setText("X2 = ${real} - ${complejo}i")
                    mostrarMensaje.setText("Su ecuación cuadrática es:")
                    mostrarEc.setText("("+varA1.toInt()+")χ² + ("+varB1.toInt()+")χ + ("+varC1.toInt()+") = 0")
                }
            }
        }


        fun limpiarPlainText(){
            //Lipiando plain text
            a1.setText("")
            b1.setText("")
            c1.setText("")
        }


        btnLimpiar.setOnClickListener {
            limpiar()
            limpiarPlainText()
        }

        btnCalcular.setOnClickListener {


            fun calcular(){


                val varA1 = (a1.getText().toString()).toDouble()

                //PRIMERA CONDICIÓN



                if(b1.getText().toString() == "" && c1.getText().toString() == "" ){

                    val varB1 = 0.0
                    val varC1 = 0.0

                    limpiar()
                    respuestaX1.setText("Única solución: X = 0")
                    mostrarMensaje.setText("Su ecuación cuadrática es:")
                    mostrarEc.setText("("+varA1.toInt()+")χ² + ("+varB1.toInt()+")χ + ("+varC1.toInt()+") = 0")


                    //SEGUNDA CONDICÓN
                }else if(b1.getText().toString() == ""){

                    val varB1 = 0.0
                    val varC1 = (c1.getText().toString()).toDouble()

                    operaciones(varA1, varB1, varC1)



                    //TERCERA CONDICIÓN
                }else if(c1.getText().toString() == ""){

                    val varB1 = (b1.getText().toString()).toDouble()
                    val varC1 = 0.0

                    operaciones(varA1, varB1, varC1)

                    //CUARTA CONDICIÓN
                }else if(b1.getText().toString() != "" && c1.getText().toString() != ""){
                    val varB1 = (b1.getText().toString()).toDouble()
                    val varC1 = (c1.getText().toString()).toDouble()

                    operaciones(varA1, varB1, varC1)

                }

            }

            if((a1.getText().toString()) == "" || (a1.getText().toString()) == "-" || (a1.getText().toString()) == "+"){
                limpiar()
                respuestaX1.setText("La variable A no puede ser nula.")
            }else if((a1.getText().toString()).toDouble() == 0.0){
                limpiar()
                respuestaX1.setText("La variable A no puede ser igual a 0.")
            }else{
                calcular()
            }
        }


    }
}