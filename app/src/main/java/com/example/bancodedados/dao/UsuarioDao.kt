package com.example.bancodedados.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bancodedados.model.Usuario


@Dao
interface UsuarioDao {

    @Insert
    fun inserir(listaUsuarios: MutableList<Usuario>)

    @Query("SELECT * FROM usuarios ORDER BY uid ASC")
    fun get(): MutableList<Usuario>

    @Query("UPDATE usuarios SET nome = :novoNome, idade = :novaIdade, peso = :novoPeso, altura = :novaAltura, imc = :novoIMC, classificacao = :novaClass " +
            "WHERE UID = :id")

    fun atualizar(
        id: Int,
        novoNome: String,
        novaIdade: String,
        novoPeso: String,
        novaAltura: String,
        novoIMC: String,
        novaClass: String
    )

    @Query("DELETE FROM usuarios WHERE uid = :id")
    fun deletar(id: Int)

    @Query("DELETE FROM usuarios")
    fun deletarTodos()
}