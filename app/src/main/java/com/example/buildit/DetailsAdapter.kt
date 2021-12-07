package com.example.buildit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buildit.Activities.*

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
                val intent = Intent(parent.context, Labouractivity::class.java)
                parent.context.startActivity(intent)
            }
            else
                if(data[holder.adapterPosition].name=="Fitter") {
                    val intent = Intent(parent.context, FitterActivity::class.java)
                    parent.context.startActivity(intent)
                }
                else
                    if(data[holder.adapterPosition].name=="Carpenter") {
                        val intent = Intent(parent.context, CarpenterActivity::class.java)
                        parent.context.startActivity(intent)
                    }
                    else
                        if(data[holder.adapterPosition].name=="Painter") {
                            val intent = Intent(parent.context, PainterActivity::class.java)
                            parent.context.startActivity(intent)
                        }
                        else
                            if(data[holder.adapterPosition].name=="Plaster Mistry") {
                                val intent = Intent(parent.context, PlasterActivity::class.java)
                                parent.context.startActivity(intent)
                            }
                            else
                                if(data[holder.adapterPosition].name=="Brickwork") {
                                    val intent = Intent(parent.context, BrickworkActivity::class.java)
                                    parent.context.startActivity(intent)
                                }
                                else
                                    if(data[holder.adapterPosition].name=="Gypsum") {
                                        val intent = Intent(parent.context, GypsumActivity::class.java)
                                        parent.context.startActivity(intent)
                                    }
                                    else
                                        if(data[holder.adapterPosition].name=="Plumber") {
                                            val intent = Intent(parent.context, PlumberActivity::class.java)
                                            parent.context.startActivity(intent)
                                        }
                                        else
                                            if(data[holder.adapterPosition].name=="Electrician") {
                                                val intent = Intent(parent.context, ElectricianActivity::class.java)
                                                parent.context.startActivity(intent)
                                            }
                                            else
                                                if(data[holder.adapterPosition].name=="Tiles") {
                                                    val intent = Intent(parent.context, TilesActivity::class.java)
                                                    parent.context.startActivity(intent)
                                                }

        }

        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item = data[position]



        holder.details_textView.text = item.name
    }

    override fun getItemCount(): Int {
        return data.size
    }
}