package com.example.mynewslistv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewslistv2.Models.NewsData
import com.example.mynewslistv2.News.NewsMaster
import com.example.mynewslistv2.Recycler.Adapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var news: NewsMaster

    var elements: MutableList<NewsData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        news = NewsMaster("http://newsapi.org/v2/top-headlines?country=us&apiKey=1b93bc09293f461aa6ce921812fc7294&q=")

        ButSearch.setOnClickListener{ OnClickSearch() }

        updateItems()

        updateRecycler(SpinnerCountry.selectedItem.toString(), EditSearch.text.toString())

        settingRecycler()
    }

    fun OnClickSearch() {

        updateRecycler(SpinnerCountry.selectedItem.toString(), EditSearch.text.toString())

        settingRecycler()
    }

    fun clearRecycler() {
        Recycler.recycledViewPool.clear()
        elements.clear()
    }

    fun updateItems() {

        for (count in 1..news.getCountNews()) {
            elements.add(NewsData(news.getTitleNews(count - 1), news.getUrlToImageNews(count - 1), news.getAuthorNews(count - 1), news.getContentNews(count - 1)))
        }
    }

    fun updateRecycler(country : String, search : String) {

        clearRecycler()
        news.refreshNews(country, search)
        updateItems()
    }

    fun settingRecycler() {

        Recycler.layoutManager = LinearLayoutManager(this)
        Recycler.setHasFixedSize(true)
        Recycler.adapter = Adapter(this, elements){

            val intent : Intent = Intent(this, The_element::class.java)
            intent.putExtra("OBJECT", it)
            startActivity(intent)

        }
    }

}