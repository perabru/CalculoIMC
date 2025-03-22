package com.example.calculoimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editPeso = findViewById<EditText>(R.id.editTextPeso)
        val editAltura = findViewById<EditText>(R.id.editTextAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textResultado = findViewById<TextView>(R.id.textResultado)


        btnCalcular.setOnClickListener {
            val pesoStr = editPeso.text.toString()
            val alturaStr = editAltura.text.toString()

            if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val imc = peso / (altura * altura)
                val resultado = when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc in 18.5..24.9 -> "Peso normal"
                    imc in 25.0..29.9 -> "Sobrepeso"
                    imc in 30.0..34.9 -> "Obesidade grau 1"
                    imc in 35.0..39.9 -> "Obesidade grau 2"
                    else -> "Obesidade grau 3"
                }

                val imcFormatado = String.format("%.2f", imc)
                textResultado.text = "IMC: $imcFormatado\nStatus: $resultado"
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}