package com.example.buildit.Activities

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildit.DataClass.SiteUserData
import com.example.buildit.DataClass.SiteUsersAdapter
import com.example.buildit.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class SiteActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site)

        val addbtn =findViewById<Button>(R.id.addbtn_site)
        addbtn.setOnClickListener {
            startActivity(Intent(this, AddSiteActivity::class.java))
        }


        database = FirebaseDatabase.getInstance().getReference("Users/${Firebase.auth.uid}")
        val site_Users = arrayListOf<SiteUserData>()

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                for(i in p0.children){



                    val steusr = i.getValue(SiteUserData::class.java)

                    site_Users.add(steusr!!)
                    Log.e(TAG,"user info" +steusr)
                }
                val recycler =  findViewById<RecyclerView>(R.id.rv_siteUsers)

                recycler.layoutManager = LinearLayoutManager(this@SiteActivity, LinearLayoutManager.VERTICAL, true)
                recycler.adapter = SiteUsersAdapter(site_Users)
            }
        })

    }


    }

