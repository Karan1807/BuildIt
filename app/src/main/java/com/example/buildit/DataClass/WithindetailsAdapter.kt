package com.example.buildit.DataClass

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buildit.Activities.DetailsActivity.data_withindetails
import com.example.buildit.R

class withindetailsAdapter (var data: ArrayList<data_withindetails>) : RecyclerView.Adapter<withindetailsAdapter.IntViewHolder>() {
    class IntViewHolder(val row: View): RecyclerView.ViewHolder(row){
        val Name_textView = row.findViewById<TextView>(R.id.name_withindetails)
        val Descriptiom_textview = row.findViewById<TextView>(R.id.description_withindetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}