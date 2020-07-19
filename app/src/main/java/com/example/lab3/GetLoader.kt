package com.example.lab3

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL


class GetLoader(var rcv:RecyclerView,var context: Context):AsyncTask<String,Void,Response>() {
    override fun doInBackground(vararg params: String?): Response {

    var url = URL("http://dotplays.com/wp-json/wp/v2/search?search="+params[0]+"&_embed")

    var urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
    urlConnection.setRequestProperty("Content-type","application/x-form-urlencoded")
    var inputStream = BufferedReader(InputStreamReader(
        urlConnection.inputStream
    ))
    val jsonResult: String = inputStream.readLine()
    val gson = Gson()
        return gson.fromJson(jsonResult, Response::class.java)
    }

    override fun onPostExecute(result: Response?) {
        var linearLayoutManager = LinearLayoutManager(context)
        rcv.layoutManager = linearLayoutManager
        rcv.adapter = RecyclerAdapter(result!!,context)
        super.onPostExecute(result)
    }
}