package com.example.at_kotlin.apiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var instance : Retrofit? = null
    private val url : String = "http://biblio.aguiar.pro.br/api/livros/30"
    private fun getInstance(): Retrofit {
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance as Retrofit
    }

    fun getAnimesService() : FilmesService
            = getInstance().create(FilmesService::class.java)
}