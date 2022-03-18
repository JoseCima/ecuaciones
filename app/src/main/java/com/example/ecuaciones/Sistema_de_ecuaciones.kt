package com.example.ecuaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.text.DecimalFormat

class Sistema_de_ecuaciones : AppCompatActivity() {





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
        val mostrarSis = findViewById<TextView>(R.id.mostrarSistema)
        val mostrarSis2 = findViewById<TextView>(R.id.mostrarSistema2)
        val mostrarEc1 = findViewById<TextView>(R.id.ecuacionUno)
        val mostrarEc2 = findViewById<TextView>(R.id.ecuacionDos)
        val limpiar = findViewById<Button>(R.id.btnLimpiar)

        /*val varA1 = 0.0
        val varA2 = 0.0
        val varB1 = 0.0
        val varB2 = 0.0
        val varC1 = 0.0
        val varC2 = 0.0*/

        fun limpiar(){
            respuestaX.setText("")
            respuestaY.setText("")
            mostrarSis.setText("")
            mostrarSis2.setText("")
            mostrarEc1.setText("")
            mostrarEc2.setText("")
        }


        fun limpiarTextPlain(){
            a1.setText("")
            a2.setText("")
            b1.setText("")
            b2.setText("")
            c1.setText("")
            c2.setText("")
        }


        limpiar.setOnClickListener {
            limpiar()
            limpiarTextPlain()
        }




        btnCalcular.setOnClickListener {


            fun calcular( varA1:Double, varA2:Double,varB1:Double, varB2:Double, varC1:Double, varC2:Double ){
                val x = (varC1*varB2 - varC2*varB1)/(varA1*varB2 - varA2*varB1)
                val y = (varA1*varC2 - varA2*varC1)/(varA1*varB2 - varA2*varB1)


                if((varA1*varB2 - varA2*varB1) != 0.0){
                    val resX = x.toString()
                    val resY = y.toString()

                    limpiar()


                    respuestaX.setText("X = "+resX)
                    respuestaY.setText("Y = "+resY)
                    mostrarEc1.setText("Su primera ecuación:")
                    mostrarEc2.setText("Su segunda ecuación:")
                    mostrarSis.setText("("+varA1.toInt()+")X + ("+varB1.toInt()+")Y = "+varC1.toInt())
                    mostrarSis2.setText("("+varA2.toInt()+")X + ("+varB2.toInt()+")Y = "+varC2.toInt())

                }else{
                    limpiar()
                    respuestaX.setText("X no tiene solución")
                    respuestaY.setText("Y no tiene solución")
                }
            }

            if(a1.getText().toString() != "" && a2.getText().toString() != "" && b1.getText().toString() != "" && b2.getText().toString() != "" && c1.getText().toString() != "" && c2.getText().toString() != ""){

                val varA1 = (a1.getText().toString()).toDouble()
                val varA2 = (a2.getText().toString()).toDouble()
                val varB1 = (b1.getText().toString()).toDouble()
                val varB2 = (b2.getText().toString()).toDouble()
                val varC1 = (c1.getText().toString()).toDouble()
                val varC2 = (c2.getText().toString()).toDouble()

                calcular(varA1, varA2, varB1, varB2, varC1, varC2)

            }else

            if(a1.getText().toString() == "" && a2.getText().toString() == "" && b1.getText().toString() == "" && b2.getText().toString() == "" && c1.getText().toString() == "" && c2.getText().toString() == ""){

                limpiar()
                respuestaX.setText("Por favor, complete los campos.")
            }else if (c1.getText().toString() == "" && c2.getText().toString() == ""){
                limpiar()
                respuestaX.setText("La variable C1 y C2 no pueden ser nulas.")
            }else


            if(c1.getText().toString() == "" ){
                limpiar()
                respuestaX.setText("La variable C1 no puede ser nula.")
            }else


            if(c2.getText().toString() == ""){
                limpiar()
                respuestaX.setText("La variable C2 no puede ser nula.")
            }else

                if(a1.getText().toString() == "" && a2.getText().toString() == ""){
                    limpiar()
                    respuestaX.setText("No existe solución.")
                }else

                    if(b1.getText().toString() == "" && b2.getText().toString() == ""){
                        limpiar()
                        respuestaX.setText("No existe solución.")
                    }else
                        if(a1.getText().toString() == "" && b1.getText().toString() == ""){
                            limpiar()
                            respuestaX.setText("No existe solución.")
                        }else
                            if(a2.getText().toString() == "" && b2.getText().toString() == ""){
                                limpiar()
                                respuestaX.setText("No existe solución.")
                            }else



                                if(a1.getText().toString() == "" && b2.getText().toString() == ""){
                                    val varA1 = 0.0
                                    val varA2 = (a2.getText().toString()).toDouble()
                                    val varB1 = (b1.getText().toString()).toDouble()
                                    val varB2 = 0.0
                                    val varC1 = (c1.getText().toString()).toDouble()
                                    val varC2 = (c2.getText().toString()).toDouble()

                                    calcular(varA1, varA2, varB1, varB2, varC1, varC2)
                                }else

                                    if(a2.getText().toString() == "" && b1.getText().toString() == ""){
                                        val varA1 = (a1.getText().toString()).toDouble()
                                        val varA2 = 0.0
                                        val varB1 = 0.0
                                        val varB2 = (b2.getText().toString()).toDouble()
                                        val varC1 = (c1.getText().toString()).toDouble()
                                        val varC2 = (c2.getText().toString()).toDouble()

                                        calcular(varA1, varA2, varB1, varB2, varC1, varC2)
                                    }else




            if(b1.getText().toString() == ""){
                val varA1 = (a1.getText().toString()).toDouble()
                val varA2 = (a2.getText().toString()).toDouble()
                val varB1 = 0.0
                val varB2 = (b2.getText().toString()).toDouble()
                val varC1 = (c1.getText().toString()).toDouble()
                val varC2 = (c2.getText().toString()).toDouble()

                calcular(varA1, varA2, varB1, varB2, varC1, varC2)
            }else


            if(b2.getText().toString() == ""){
                val varA1 = (a1.getText().toString()).toDouble()
                val varA2 = (a2.getText().toString()).toDouble()
                val varB1 = (b1.getText().toString()).toDouble()
                val varB2 = 0.0
                val varC1 = (c1.getText().toString()).toDouble()
                val varC2 = (c2.getText().toString()).toDouble()

                calcular(varA1, varA2, varB1, varB2, varC1, varC2)
            }else


            if(a1.getText().toString() == ""){

                val varA1 = 0.0
                val varA2 = (a2.getText().toString()).toDouble()
                val varB1 = (b1.getText().toString()).toDouble()
                val varB2 = (b2.getText().toString()).toDouble()
                val varC1 = (c1.getText().toString()).toDouble()
                val varC2 = (c2.getText().toString()).toDouble()

                calcular(varA1, varA2, varB1, varB2, varC1, varC2)
            }else

            if(a2.getText().toString() == ""){

                val varA1 = (a1.getText().toString()).toDouble()
                val varA2 = 0.0
                val varB1 = (b1.getText().toString()).toDouble()
                val varB2 = (b2.getText().toString()).toDouble()
                val varC1 = (c1.getText().toString()).toDouble()
                val varC2 = (c2.getText().toString()).toDouble()

                calcular(varA1, varA2, varB1, varB2, varC1, varC2)
            }









        }




    }
}