package com.example.bancodedados.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario (
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "idade") val idade: String,
    @ColumnInfo(name = "peso") val peso: String,
    @ColumnInfo(name = "altura") val altura: String,
    @ColumnInfo(name = "imc") val imc: String,
    @ColumnInfo(name = "classificacao") val classificacao: String
)

{
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}