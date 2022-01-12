package com.example.buildit.Activities.ManagerDashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildit.Activities.DetailsActivity.DetailsAdapter
import com.example.buildit.R
import com.example.buildit.data_details

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val details_recycler = findViewById<RecyclerView>(R.id.Details_RecyclerView)


        val data1 = arrayListOf<data_details>()

        data1.add(data_details("", "Labour"))
        data1.add(data_details("", "Fitter"))
        data1.add(data_details("", "Carpenter"))
        data1.add(data_details("", "Painter"))
        data1.add(data_details("", "Plaster Mistry"))
        data1.add(data_details("", "Brickwork"))
        data1.add(data_details("", "Gypsum"))
        data1.add(data_details("", "Plumber"))
        data1.add(data_details("", "Electrician"))
        data1.add(data_details("", "Tiles"))

        details_recycler.layoutManager = GridLayoutManager(this,2)
        details_recycler.adapter = DetailsAdapter(data1)

    }
}