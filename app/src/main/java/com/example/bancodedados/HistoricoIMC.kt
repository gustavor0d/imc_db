package com.example.bancodedados

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bancodedados.adapter.HistoricoAdapter
import com.example.bancodedados.dao.UsuarioDao
import com.example.bancodedados.databinding.ActivityHistoricoImcBinding
import com.example.bancodedados.model.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.view.View
import kotlinx.coroutines.withContext


class HistoricoIMC : AppCompatActivity() {

    private lateinit var binding: ActivityHistoricoImcBinding
    private lateinit var usuarioDao: UsuarioDao
    private lateinit var historicoAdapter: HistoricoAdapter
    private val listaUsuarios = MutableLiveData<MutableList<Usuario>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoricoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioDao = AppDatabase.getInstance(this).usuarioDao()

        historicoAdapter = HistoricoAdapter(this, mutableListOf())

        binding.recyclerViewContatos.apply {
            layoutManager = LinearLayoutManager(this@HistoricoIMC)
            setHasFixedSize(true)
            adapter = historicoAdapter
        }

        listaUsuarios.observe(this) { lista ->
            historicoAdapter.atualizarLista(lista)
        }

        binding.btnVoltar3.setOnClickListener {
            startActivity(Intent(this, CalcularIMC::class.java))
        }

        binding.btnDeletarTodos.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val lista = usuarioDao.get()

                withContext(Dispatchers.Main) {
                    if (lista.isEmpty()) {
                        Toast.makeText(
                            this@HistoricoIMC,
                            "Nenhum histórico para apagar.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            usuarioDao.deletarTodos()
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@HistoricoIMC,
                                    "Histórico apagado com sucesso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            }
                        }
                    }
                }
            }
        }

        getContatos()
    }

    override fun onResume() {
        super.onResume()
        getContatos()
    }

    private fun getContatos() {
        CoroutineScope(Dispatchers.IO).launch {
            val lista = usuarioDao.get()
            withContext(Dispatchers.Main) {
                if (lista.isEmpty())
                    binding.txtSemHistorico.visibility = View.VISIBLE
                else
                    binding.txtSemHistorico.visibility = View.GONE
                listaUsuarios.value = lista
            }
        }
    }
}
