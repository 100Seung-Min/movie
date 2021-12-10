package com.example.movieranking.retrofit

import com.example.movieranking.DTO.DetailMovieData
import com.example.movieranking.DTO.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*

interface RetrofitInterface {
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    fun movieData(
        @Query("key") key: String = "f5eef3421c602c6cb7ea224104795888",
        @Query("targetDt") date: String = (SimpleDateFormat("yyyyMMdd").format(Date()).toInt() - 1).toString()
    ): Call<MovieData>

    @GET("movie/searchMovieInfo.json")
    fun detailMove(
        @Query("key") key: String = "f5eef3421c602c6cb7ea224104795888",
        @Query("movieCd") movieCd: String
    ): Call<DetailMovieData>
}