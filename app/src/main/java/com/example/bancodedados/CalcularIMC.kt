package com.example.bancodedados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bancodedados.model.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CalcularIMC : AppCompatActivity() {

    private lateinit var btnHistorico: Button
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_imc)

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtIdade = findViewById<EditText>(R.id.edtIdade)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val nomeVazio = edtNome.text.isNullOrBlank()
            val idadeVazio = edtIdade.text.isNullOrBlank()
            val peso = edtPeso.text.toString().toFloatOrNull()
            val altura = edtAltura.text.toString().toFloatOrNull()

            when {
                nomeVazio -> Toast.makeText(applicationContext, "Campo nome vazio.", Toast.LENGTH_SHORT).show()
                idadeVazio -> Toast.makeText(applicationContext, "Campo idade vazio.", Toast.LENGTH_SHORT).show()
                peso == null -> Toast.makeText(applicationContext, "Campo peso vazio.", Toast.LENGTH_SHORT).show()
                altura == null -> Toast.makeText(applicationContext, "Campo altura vazio.", Toast.LENGTH_SHORT).show()
                altura == 0f -> Toast.makeText(applicationContext, "Valor do campo altura não pode ser igual a 0.", Toast.LENGTH_SHORT).show()
                else -> {
                    val imc = peso / (altura * altura)
                    val classificacao = when {
                        imc < 18.5 -> "Abaixo do peso"
                        imc < 24.9 -> "Peso normal"
                        imc < 29.9 -> "Sobrepeso"
                        imc < 34.9 -> "Obesidade grau 1"
                        imc < 39.9 -> "Obesidade grau 2"
                        else -> "Obesidade grau 3"
                    }

                    var imcString = String.format("%.2f", imc)
                    imcString = imcString.replace('.', ',')
                    txtResultado.text = "IMC: $imcString\n$classificacao"

                    val nome = edtNome.text.toString()
                    val idade = edtIdade.text.toString()
                    var pesoString = String.format("%.2f", peso)
                    pesoString = pesoString.replace('.', ',')
                    var alturaString = String.format("%.2f", altura)
                    alturaString = alturaString.replace('.', ',')
                    val usuario = Usuario(nome, idade, pesoString, alturaString, imcString, classificacao)

                    Toast.makeText(applicationContext, "IMC calculado com sucesso!", Toast.LENGTH_SHORT).show()

                    CoroutineScope(Dispatchers.IO).launch {
                        val usuarioDao = AppDatabase.getInstance(this@CalcularIMC).usuarioDao()
                        usuarioDao.inserir(mutableListOf(usuario))
                    }
                }
            }
        }

        btnVoltar = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnHistorico = findViewById(R.id.btnHistorico)
        btnHistorico.setOnClickListener {
            val intent = Intent(this, HistoricoIMC::class.java)
            startActivity(intent)
        }
    }
}
