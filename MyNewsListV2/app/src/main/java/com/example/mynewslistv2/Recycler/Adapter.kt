package com.example.mynewslistv2.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewslistv2.Models.NewsData
import com.example.mynewslistv2.R
import com.squareup.picasso.Picasso

class Adapter(val context: Context, val item : MutableList<NewsData>, val listener: (NewsData) -> Unit) : RecyclerView.Adapter<Adapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.template, parent, false))

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: Adapter.MainHolder, position: Int) {
        holder.bind(item.get(position))
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val Im : ImageView = itemView.findViewById(R.id.Im)
        private val Name : TextView = itemView.findViewById(R.id.Name)
        private val Content : TextView = itemView.findViewById(R.id.Content)
        private val Author : TextView = itemView.findViewById(R.id.Author)

        fun bind(item : NewsData) {
            if(item.url.length != 0)
            {
                Picasso.get().load(item.url).fit().placeholder(R.drawable.black).error(R.drawable.black).into(Im)
            }
            Name.text = "Title: " + item.name
            Content.text = "Content: " + item.content
            Author.text = "Author: " + item.author

            itemView.setOnClickListener{listener(item)}
        }

    }
}