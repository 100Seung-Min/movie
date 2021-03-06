package com.example.movieranking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieranking.DTO.MovieData
import com.example.movieranking.DTO.dailyBoxOfficeList
import com.example.movieranking.Fragment.MovieRanking
import com.example.movieranking.adapter.MoviewRecyclerAdapter
import com.example.movieranking.databinding.ActivityMainBinding
import com.example.movieranking.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, MovieRanking()).commit()
        RetrofitClient.api.getRecentMovie().enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("여기 ${response}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                println("여기 ${t}")
            }

        })
    }
}