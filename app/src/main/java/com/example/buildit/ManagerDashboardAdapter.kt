package com.example.buildit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ManagerDashboardAdapter(var data: ArrayList<data_rv>) : RecyclerView.Adapter<ManagerDashboardAdapter.IntViewHolder>() {
    class IntViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val textView = row.findViewById<TextView>(R.id.manager_dash_text)
        val imageView = row.findViewById<ImageView>(R.id.manager_dash_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        val holder = IntViewHolder(layout)
        layout.setOnClickListener {
            val intent = Intent(parent.context,SecondActivity::class.java)
            parent.context.startActivity(intent)
        }

        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}