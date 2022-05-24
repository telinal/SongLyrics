package com.example.songlyrics.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private const val BASE_URL = "https://genius.p.rapidapi.com/"
    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getListSong() : RetrofitInterface {
        return getInstance().create(RetrofitInterface::class.java)
    }
}