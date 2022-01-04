package com.example.buildit.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.buildit.DataClass.ManagerDashboard
import com.example.buildit.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val site_cardview = findViewById<CardView>(R.id.site_cardView)
        site_cardview.setOnClickListener {
            val intent = Intent(this, ManagerDashboard::class.java)
            startActivity(intent)

        }

    }
}

