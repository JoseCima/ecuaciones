package com.example.ecuaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ptName = findViewById<EditText>(R.id.ptUser)

        val ptPassword = findViewById<EditText>(R.id.ptPasword)

        val bIngresar = findViewById<Button>(R.id.btnCalcular)

        bIngresar.setOnClickListener{
            val nUsuario = ptName.getText().toString()
            val pass:String = ptPassword.getText().toString()
            if(nUsuario.equals("JoseCima") || pass.equals("1234")){
                if(nUsuario.equals("JoseCima")){
                    if(pass.equals("1234")){
                        var intent = Intent(this,Opciones::class.java)
                        startActivity(intent)
                        Toast.makeText(this,"Bienvenido "+ ptName.text + ", resolvamos esas ecuaciones!", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Su Contraseña es Incorrecta", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this,"Su Usuario es Incorrecto", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this,"Ambas Credenciales son Incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}