package com.example.movieranking.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    lateinit var api : RetrofitInterface
    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        var retrofit = Retrofit.Builder()
//            .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/")
            .baseUrl("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        api = retrofit.create(RetrofitInterface::class.java)
    }
}