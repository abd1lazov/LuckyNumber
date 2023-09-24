package com.example.luckynumber

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1: Button = findViewById(R.id.btn_luck)
        val t1: TextView = findViewById(R.id.tv_welcome)
        val et: EditText = findViewById(R.id.et_name)

        b1.setOnClickListener() {
            var username = et.text
            var i = Intent(this, LuckyNumberActivity::class.java)
            i.putExtra("name", username)
            startActivity(i)
        }
    }
}