package com.example.movieranking.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieranking.DTO.MovieData
import com.example.movieranking.DTO.dailyBoxOfficeList
import com.example.movieranking.DetailMovie
import com.example.movieranking.R

class MoviewRecyclerAdapter(val itemlist: ArrayList<dailyBoxOfficeList>, val context: Context?): RecyclerView.Adapter<MoviewRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: dailyBoxOfficeList, context: Context){
            itemView.findViewById<TextView>(R.id.rank_txt).text = item.rank
            itemView.findViewById<TextView>(R.id.movie_txt).text = item.movieNm
            itemView.findViewById<LinearLayout>(R.id.movie_item_layout).setOnClickListener {
                val intent = Intent(context, DetailMovie::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                intent.putExtra("movieCd", item.movieCd)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = LayoutInflater.from(parent.context).inflate(R.layout.movie_rank_item, parent, false)
        return ViewHolder(inflateView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemlist[position], context!!)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}