package com.example.at_kotlin.apiService

import com.example.at_kotlin.model.Filme
import retrofit2.http.GET

interface FilmesService {

    // Listar todos os Recursos
    @GET("/anime?filter[text]=Naruto")
    fun all() : retrofit2.Call<List<Filme>>

}
