package com.example.mynewslistv2.News

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class NewsMaster(url : String) {

    private var ListAuthor : MutableList<String> = mutableListOf()
    private var ListContents : MutableList<String> = mutableListOf()
    private var ListUrlsOfImage : MutableList<String> = mutableListOf()
    private var ListTitles : MutableList<String> = mutableListOf()

    private var CountNews : Int = 0

    private var jsonurl : String = url

    init{
        val Client : OkHttpClient = OkHttpClient()
        val req : Request = Request.Builder().url(url).build()

        var jsonResult : String = ""

        Client.newCall(req).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                jsonResult = "Error"
            }

            override fun onResponse(call: Call, response: Response) {
                jsonResult = response.body!!.string()
            }
        })

        while(jsonResult == "") { }

        val count : Int = (JSONObject(jsonResult).getJSONArray("articles").length())

        if(jsonResult != "Error"){

            for(count2 in 1..count)
            {
                ListAuthor.add((JSONObject(jsonResult).getJSONArray("articles").getJSONObject(count2 - 1)).get("author").toString())
                ListContents.add((JSONObject(jsonResult).getJSONArray("articles").getJSONObject(count2 - 1)).get("content").toString())
                ListUrlsOfImage.add((JSONObject(jsonResult).getJSONArray("articles").getJSONObject(count2 - 1)).get("urlToImage").toString())
                ListTitles.add((JSONObject(jsonResult).getJSONArray("articles").getJSONObject(count2 - 1)).get("title").toString())
            }

            CountNews = count
        }
        else
        {
            ListAuthor.add("Error")
            ListContents.add("Error")
            ListUrlsOfImage.add("Error")

            CountNews = 1
        }
    }

    fun getCountNews() : Int {
        return CountNews
    }

    fun getTitleNews(index : Int) : String{
        return ListTitles.get(index)
    }

    fun getAuthorNews(index : Int) : String{
        return ListAuthor.get(index)
    }

    fun getUrlToImageNews(index : Int) : String{
        return ListUrlsOfImage.get(index)
    }

    fun getContentNews(index : Int) : String{
        return ListContents.get(index)
    }

    fun clearList() {
        ListAuthor.clear()
        ListContents.clear()
        ListTitles.clear()
        ListUrlsOfImage.clear()

        CountNews = 0
    }

    fun refreshNews(country : String, search: String) {
        clearList()
        getInfo(country, search)
    }

    fun getInfo(country : String, search : String)
    {
        val httpClient : OkHttpClient = OkHttpClient()

        val request : Request = Request.Builder().url(jsonurl.replace("country=us", "country=$country").replace("q=", "q=$search")).build()

        val response : Response = httpClient.newCall(request).execute()

        var json : String = ""

        clearList()

        if(response.isSuccessful) {
            json = response.body!!.string()
            }
        else {
            json = "{'articles': [{'author': null, 'title': null, 'urlToImage': null, 'content': null}]}"
        }

        val count : Int = (JSONObject(json).getJSONArray("articles").length())

        for(count2 in 1..count)
        {
            ListAuthor.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("author").toString())
            //Наполняем лист авторов полученными авторами
            ListContents.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("content").toString())
            ListUrlsOfImage.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("urlToImage").toString())
            ListTitles.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("title").toString())
        }

        CountNews = count
    }

}