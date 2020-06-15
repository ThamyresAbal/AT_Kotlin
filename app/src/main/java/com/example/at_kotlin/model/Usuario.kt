package com.example.at_kotlin.model

class Usuario (
    var email: String, var senha: String, listaFavoritos: List<ListaFavorito>? = null
){
}