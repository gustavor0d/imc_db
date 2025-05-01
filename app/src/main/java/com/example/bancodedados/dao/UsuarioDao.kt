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

    @Query("DELETE FROM usuarios")
    fun deletarTodos()
}