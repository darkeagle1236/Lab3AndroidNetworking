package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_search.setOnClickListener {
            var networkLoader = GetLoader(rcv_item,this)
            networkLoader.execute(edt_query.text.toString())
        }
    }
}
