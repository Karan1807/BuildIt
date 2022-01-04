package com.example.buildit.DataClass

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.buildit.Activities.AddSiteActivity

import com.example.buildit.R

class SiteUsersAdapter (private val SiteUsersData:ArrayList<SiteUserData>) : RecyclerView.Adapter<SiteUsersAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: SiteUsersAdapter.ViewHolder, position: Int) {
        val SiteUsersData = SiteUsersData[position]
        holder.Name_site.text = SiteUsersData.Name.toString()
        holder.Address.text = SiteUsersData.Address.toString()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteUsersAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.site_users,parent,false)
        val holder  = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context,AddSiteActivity::class.java)
            intent.putExtra("Name",SiteUsersData[holder.adapterPosition].Name)
            intent.putExtra("Address",SiteUsersData[holder.adapterPosition].Address)
            parent.context.startActivity(intent)
        }
        return holder
    }



    override fun getItemCount(): Int {
       return SiteUsersData.size
    }


    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        val Name_site : TextView = itemView.findViewById(R.id.site_name_textview2)
        val Address: TextView = itemView.findViewById(R.id.site_address_textview2)
    }

}
