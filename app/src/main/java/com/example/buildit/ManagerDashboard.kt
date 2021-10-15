package com.example.buildit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class ManagerDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_dashboard)

        val site_cardview = findViewById<CardView>(R.id.site_cardView)
        val material_purchase_cardview = findViewById<CardView>(R.id.material_purchase_card)
        val material_consumption_cardview = findViewById<CardView>(R.id.Material_consumption_card)
        val summary_cardview = findViewById<CardView>(R.id.Summary_card)
        val details_cardview = findViewById<CardView>(R.id.cardView2)

        site_cardview.setOnClickListener {
            val intent = Intent(this, SiteActivity::class.java)
            startActivity(intent)
        }

        material_purchase_cardview.setOnClickListener {
            val intent = Intent(this, MaterialPurchase::class.java)
            startActivity(intent)
        }

        material_consumption_cardview.setOnClickListener {
            val intent = Intent(this, MaterialConsumption::class.java)
            startActivity(intent)
        }

        summary_cardview.setOnClickListener {
            val intent = Intent(this, Summary::class.java)
            startActivity(intent)
        }

        details_cardview.setOnClickListener {
            val intent = Intent(this,DetailsActivity::class.java)
            startActivity(intent)
        }
    }
}