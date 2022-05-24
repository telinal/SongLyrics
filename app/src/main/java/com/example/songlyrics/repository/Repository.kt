package com.example.songlyrics.repository

import com.example.songlyrics.api.RetrofitInterface
import com.example.songlyrics.model.Hits
import com.example.songlyrics.model.SearchResponse
import retrofit2.Response

class Repository(val retrofitInterface: RetrofitInterface) {

     suspend fun getSong(q: String): Response<SearchResponse> = retrofitInterface.getSong(q = q)
}