package com.example.movieranking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieranking.DTO.MovieData
import com.example.movieranking.DTO.dailyBoxOfficeList
import com.example.movieranking.adapter.MoviewRecyclerAdapter
import com.example.movieranking.databinding.ActivityMainBinding
import com.example.movieranking.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var adapter: MoviewRecyclerAdapter
    var itemlist: ArrayList<dailyBoxOfficeList> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter = MoviewRecyclerAdapter(itemlist, this)
        binding.movieRecyclerview.adapter = adapter
        binding.movieRecyclerview.layoutManager = LinearLayoutManager(this)

        RetrofitClient.api.movieData().enqueue(object : Callback<MovieData>{
            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                for(data in response.body()!!.boxOfficeResult.dailyBoxOfficeList){
                    itemlist.add(data)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MovieData>, t: Throwable) {
                println("여기 에러${t}")
            }
        })
    }
}