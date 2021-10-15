package com.example.buildit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DetailsAdapter (var data: ArrayList<data_details>) : RecyclerView.Adapter<DetailsAdapter.IntViewHolder>() {
    class IntViewHolder(val row: View): RecyclerView.ViewHolder(row){
        val details_textView = row.findViewById<TextView>(R.id.detailsrv_text)
        val details_imageView = row.findViewById<ImageView>(R.id.detailsrv_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.itemview_details,parent,false)

        val holder = IntViewHolder(layout)
        layout.setOnClickListener {
            if(data[holder.adapterPosition].name=="Labour") {
                val intent = Intent(parent.context, InformationActivity::class.java)
                parent.context.startActivity(intent)
            }

        }

        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item = data[position]
        Glide.with(holder.details_imageView.context).load(item.Image).into(holder.details_imageView)


        holder.details_textView.text = item.name.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}