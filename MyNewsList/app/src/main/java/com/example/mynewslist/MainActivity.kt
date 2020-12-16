package com.example.mynewslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewslist.Models.NewsData
import com.example.mynewslist.News.NewsMaster
import com.example.mynewslist.Recycler.Adapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val news : NewsMaster = NewsMaster("http://newsapi.org/v2/top-headlines?country=us&apiKey=bc62f7ad76fb4ac6b5f4542b18ad8507")

        val items : MutableList<NewsData> = mutableListOf()

        for(count in 1..news.getCountNews())
        {
            items.add(NewsData(news.getTitleNews(count - 1), news.getUrlToImageNews(count - 1), news.getAuthorNews(count - 1), news.getContentNews(count - 1)))
        }

        Recycl.layoutManager  = LinearLayoutManager(this)
        Recycl.setHasFixedSize(true)
        Recycl.adapter = Adapter(items)
    }
}