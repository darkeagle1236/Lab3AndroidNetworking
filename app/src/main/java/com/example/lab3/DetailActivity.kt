package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent!=null){
            tv_id.text ="ID : "+ intent.getIntExtra("id",0)
            tv_Title.text = intent.getStringExtra("title")
            tv_subType.text = "Sub Type :"+ intent.getStringExtra("subType")
            tv_date.text = "URL :"+ intent.getStringExtra("url")
            tv_views.text = "Type :"+ intent.getStringExtra("type")
        }
    }
}
