package com.example.bancodedados.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bancodedados.databinding.ItensHistoricoBinding
import com.example.bancodedados.model.Usuario

class HistoricoAdapter(
    private val context: Context,
    private var listaUsuarios: MutableList<Usuario>
) : RecyclerView.Adapter<HistoricoAdapter.ContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val itemLista = ItensHistoricoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ContatoViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val usuario = listaUsuarios[position]

        holder.txtID.text = "ID: ${usuario.uid}"
        holder.txtNome.text = "Nome: ${usuario.nome}"
        holder.txtIdade.text = "Idade: ${usuario.idade}"
        holder.txtPeso.text = "Peso: ${usuario.peso} kg"
        holder.txtAltura.text = "Altura: ${usuario.altura} m"
        holder.txtImc.text = "IMC: ${usuario.imc}"
        holder.txtClassificacao.text = "Classificação: ${usuario.classificacao}"
    }

    override fun getItemCount() = listaUsuarios.size

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
    }
}
