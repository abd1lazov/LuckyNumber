package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luckky_number)

        val text1: TextView = findViewById(R.id.tv_text)
        val lucky_text: TextView = findViewById(R.id.tv_number)
        val btn: Button = findViewById(R.id.btn_share)

        val user_name = receiveUserName()

        val random_num = generateRandomNumber()
//        Toast.makeText(this, "" + random_num, Toast.LENGTH_LONG).show()
        lucky_text.setText("" + random_num)

        btn.setOnClickListener() {
            sharingData(user_name, random_num)
        }
    }

    private fun receiveUserName(): String {
        val bundle: Bundle? = intent.extras
        val username = bundle?.get("name").toString()
        return username
    }

    //    Random number generate
    private fun generateRandomNumber(): Int {
        val random = Random.nextInt(1000)
        return random
    }

    //    sharing username & lucky number
    private fun sharingData(name: String, number: Int) {
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, "$name Is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $number")
        startActivity(i)

    }
}