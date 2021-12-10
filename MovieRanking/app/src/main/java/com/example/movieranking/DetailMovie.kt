package com.example.movieranking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieranking.DTO.DetailMovieData
import com.example.movieranking.databinding.ActivityDetailMovieBinding
import com.example.movieranking.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovie : AppCompatActivity() {

    val binding by lazy { ActivityDetailMovieBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val movieCd = intent.getStringExtra("movieCd")
        RetrofitClient.api.detailMove(movieCd = movieCd!!).enqueue(object : Callback<DetailMovieData>{
            override fun onResponse(
                call: Call<DetailMovieData>,
                response: Response<DetailMovieData>
            ) {
                println("여기 ${response.body()}")
            }

            override fun onFailure(call: Call<DetailMovieData>, t: Throwable) {
                println("여기 ${t}")
            }
        })
    }
}