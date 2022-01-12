package com.example.buildit.Activities.ManagerDashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.buildit.Activities.SiteActivities.AddSiteActivity
import com.example.buildit.R

class ManagerDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_dashboard)


        val site_name = intent.getStringExtra("Name")?:""



        val material_purchase_cardview = findViewById<CardView>(R.id.material_purchase_card)
        material_purchase_cardview.setOnClickListener {
            val intent = Intent(this, MaterialPurchase::class.java)
            startActivity(intent)
        }
        val material_consumption_cardview = findViewById<CardView>(R.id.Material_consumption_card)
        material_consumption_cardview.setOnClickListener {
            val intent = Intent(this, MaterialConsumption::class.java)
            intent.putExtra("Name",site_name)
            startActivity(intent)

        }
        val summary_cardview = findViewById<CardView>(R.id.Summary_card)
        summary_cardview.setOnClickListener {
            val intent = Intent(this, Summary::class.java)
            startActivity(intent)
        }
        val details_cardview = findViewById<CardView>(R.id.cardView2)
        details_cardview.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }
}