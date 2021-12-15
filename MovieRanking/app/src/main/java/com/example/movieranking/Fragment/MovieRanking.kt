package com.example.movieranking.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieranking.DTO.MovieData
import com.example.movieranking.DTO.dailyBoxOfficeList
import com.example.movieranking.R
import com.example.movieranking.adapter.MoviewRecyclerAdapter
import com.example.movieranking.databinding.FragmentMovieRankingBinding
import com.example.movieranking.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRanking : Fragment() {

    lateinit var binding: FragmentMovieRankingBinding
    lateinit var adapter: MoviewRecyclerAdapter
    var itemlist: ArrayList<dailyBoxOfficeList> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieRankingBinding.inflate(inflater, container, false)
        adapter = MoviewRecyclerAdapter(itemlist, context)
        binding.movieRecyclerview.adapter = adapter
        binding.movieRecyclerview.layoutManager = LinearLayoutManager(context)

//        RetrofitClient.api.movieData().enqueue(object : Callback<MovieData> {
//            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
//                for(data in response.body()!!.boxOfficeResult.dailyBoxOfficeList){
//                    itemlist.add(data)
//                }
//                adapter.notifyDataSetChanged()
//            }
//
//            override fun onFailure(call: Call<MovieData>, t: Throwable) {
//                println("여기 에러${t}")
//            }
//        })
        return binding.root
    }
}