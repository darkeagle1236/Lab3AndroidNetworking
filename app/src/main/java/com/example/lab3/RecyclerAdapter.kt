package com.example.lab3

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_response.view.*

class RecyclerAdapter(var itemList: Response, var context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v: View =
            LayoutInflater.from(context)
                .inflate(R.layout.item_response, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = itemList[position].title
        holder.tvDate.text = "Loại : "+itemList[position].type
        holder.tvViews.text = "Link : "+itemList[position].url
        holder.itemView.setOnClickListener {
            var intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("title",itemList[position].title)
            intent.putExtra("id",itemList[position].id)
            intent.putExtra("type",itemList[position].type)
            intent.putExtra("subType",itemList[position].subtype)
            intent.putExtra("url",itemList[position].url)
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        var tvTitle: TextView = v.tv_Title
        var tvDate: TextView = v.tv_date
        var tvViews: TextView = v.tv_views
    }
}