package com.example.bancodedados

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bancodedados.dao.UsuarioDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.bancodedados.databinding.ActivityAtualizarImcBinding


class AtualizarIMC : AppCompatActivity() {

    private lateinit var binding: ActivityAtualizarImcBinding
    private lateinit var usuarioDao: UsuarioDao
    private lateinit var btnCancelar: Button

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAtualizarImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uid = intent.extras!!.getInt("uid")
        val nomeRecuperado = intent.extras?.getString("nome")
        val idadeRecuperada = intent.extras?.getString("idade")
        val pesoRecuperado = intent.extras?.getString("peso")
        val alturaRecuperada = intent.extras?.getString("altura")

        var pesoString = pesoRecuperado?.replace(',', '.')
        var alturaString = alturaRecuperada?.replace(',', '.')

        binding.attNome.setText(nomeRecuperado)
        binding.attIdade.setText(idadeRecuperada)
        binding.attPeso.setText(pesoString)
        binding.attAltura.setText(alturaString)

        binding.btnAtualizacao.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val nome = binding.attNome.text.toString()
                val idade = binding.attIdade.text.toString()
                var peso = binding.attPeso.text.toString()
                var altura = binding.attAltura.text.toString()
                val mensagem: Boolean

                if (nome.isEmpty() || idade.isEmpty() || peso.isEmpty() || altura.isEmpty() || altura.toFloat() == 0f)
                    mensagem = false
                else {
                    mensagem = true

                    val imc = peso.toFloat() / (altura.toFloat() * altura.toFloat())

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

                    peso = peso.replace('.', ',')
                    altura = altura.replace('.', ',')

                    atualizarContato(uid, nome, idade, peso, altura, imcString, classificacao)
                }

                withContext(Dispatchers.Main) {
                    if (mensagem) {
                        Toast.makeText(
                            this@AtualizarIMC,
                            "Atualização realizada com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(
                            this@AtualizarIMC,
                            "Não deixe campos vazios ou valores iguais a 0.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        btnCancelar = findViewById(R.id.btnCancelar)
        btnCancelar.setOnClickListener {val intent = Intent(this, HistoricoIMC::class.java)
            startActivity(intent)
            Toast.makeText(
                this@AtualizarIMC,
                "Operação cancelada!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun atualizarContato(uid: Int, nome: String, idade: String, peso: String, altura: String, imc: String, classificacao: String){
        usuarioDao = AppDatabase.getInstance(this).usuarioDao()
        usuarioDao.atualizar(uid, nome, idade, peso, altura, imc, classificacao)
    }
}
