package com.example.bancodedados.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bancodedados.AppDatabase
import com.example.bancodedados.AtualizarIMC
import com.example.bancodedados.dao.UsuarioDao
import com.example.bancodedados.databinding.ItensHistoricoBinding
import com.example.bancodedados.model.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HistoricoAdapter(
    private val context: Context,
    private var listaUsuarios: MutableList<Usuario>
) : RecyclerView.Adapter<HistoricoAdapter.ContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val itemLista = ItensHistoricoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ContatoViewHolder(itemLista)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val usuario = listaUsuarios[position]

        holder.txtID.text = "ID: ${usuario.uid}"
        holder.txtNome.text = "Nome: ${usuario.nome}"
        holder.txtIdade.text = "Idade: ${usuario.idade}"
        holder.txtPeso.text = "Peso: ${usuario.peso} kg"
        holder.txtAltura.text = "Altura: ${usuario.altura} m"
        holder.txtImc.text = "IMC: ${usuario.imc}"
        holder.txtClassificacao.text = "Classificação: ${usuario.classificacao}"


        holder.btnAtualizar.setOnClickListener{
            val intent = Intent(context, AtualizarIMC::class.java)

            intent.putExtra("uid", listaUsuarios[position].uid)
            intent.putExtra("nome", listaUsuarios[position].nome)
            intent.putExtra("idade", listaUsuarios[position].idade)
            intent.putExtra("peso", listaUsuarios[position].peso)
            intent.putExtra("altura", listaUsuarios[position].altura)
            context.startActivity(intent)
        }

        holder.btnDeletar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val usuarioDao: UsuarioDao = AppDatabase.getInstance(context).usuarioDao()
                usuarioDao.deletar(usuario.uid)
                listaUsuarios.remove(usuario)

                withContext(Dispatchers.Main){
                    Toast.makeText(context, "Registro deletado com sucesso.", Toast.LENGTH_SHORT).show()
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount() = listaUsuarios.size

    @SuppressLint("NotifyDataSetChanged")
    fun atualizarLista(novaLista: MutableList<Usuario>) {
        listaUsuarios = novaLista
        notifyDataSetChanged()
    }

    inner class ContatoViewHolder(binding: ItensHistoricoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val txtID = binding.txtID
        val txtNome = binding.txtNome
        val txtIdade = binding.txtIdade
        val txtPeso = binding.txtPeso
        val txtAltura = binding.txtAltura
        val txtImc = binding.txtImc
        val txtClassificacao = binding.txtClassificacao
        val btnAtualizar  = binding.btnAtualizar
        val btnDeletar    = binding.btnDeletar
    }
}
