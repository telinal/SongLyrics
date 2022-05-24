package com.example.songlyrics.api

import com.example.songlyrics.model.Hits
import com.example.songlyrics.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


//https://genius.p.rapidapi.com/search?q=perfect
interface RetrofitInterface {


    @GET("/search")
    suspend fun getSong(
        @Header("X-RapidAPI-Host") host: String = "genius.p.rapidapi.com",
        @Header("X-RapidAPI-Key") key: String = com.example.songlyrics.BuildConfig.API_KEY,
        @Query("access_key") apiKey: String = com.example.songlyrics.BuildConfig.API_KEY,
        @Query("q") q: String
    ): Response<SearchResponse>

}