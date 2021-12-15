package com.example.movieranking.retrofit

import com.example.movieranking.DTO.DetailMovieData
import com.example.movieranking.DTO.MovieData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*

interface RetrofitInterface {
//    @GET("boxoffice/searchDailyBoxOfficeList.json")
//    fun movieData(
//        @Query("key") key: String = "f5eef3421c602c6cb7ea224104795888",
//        @Query("targetDt") date: String = (SimpleDateFormat("yyyyMMdd").format(Date()).toInt() - 1).toString()
//    ): Call<MovieData>
//
//    @GET("movie/searchMovieInfo.json")
//    fun detailMove(
//        @Query("key") key: String = "f5eef3421c602c6cb7ea224104795888",
//        @Query("movieCd") movieCd: String
//    ): Call<DetailMovieData>
    @GET("search_json2.jsp")
    fun getRecentMovie(
        @Query("ServiceKey") key: String = "E0JK76J2G2SQMEVTGZ0P",
        @Query("collection") collection: String = "kmdb_new2",
        @Query("releaseDts") startDt: String = SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, 1)
            add(Calendar.MONTH, -1) }.time ),
        @Query("releaseDte") endDt: String = SimpleDateFormat("yyyyMMdd").format(Date()),
        @Query("listCount") listCnt: String = "30"
    ): Call<ResponseBody>
}