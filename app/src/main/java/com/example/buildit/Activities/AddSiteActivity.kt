package com.example.buildit.Activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.buildit.DataClass.userdata
import com.example.buildit.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class
AddSiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_site)
        val sign_out = findViewById<Button>(R.id.sign_out_btn)
        val name = findViewById<TextInputEditText>(R.id.name_site)
        val address = findViewById<TextInputEditText>(R.id.address_site)



        val addsite_btn = findViewById<Button>(R.id.add_sitebtn)

        val database = Firebase.database.getReference("Site/${Firebase.auth.uid}")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                name.setText(snapshot.child("Name").value.toString())
                address.setText(snapshot.child("Address").value.toString())

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })




        addsite_btn.setOnClickListener {

            updateData(name.text.toString(),address.text.toString())


        }
        sign_out.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))

        }

    }

    private fun updateData(name: String, address: String) {
        val database = Firebase.database.reference
        val key = database.child("Users").push().key
        val user_data = userdata(name,address)
        val data = user_data.toMap()
        val userupdates = hashMapOf<String, Any>("Users/${Firebase.auth.uid}/$key" to data)
        database.updateChildren(userupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG,"Successfully stored user data to firebase db")
            startActivity(Intent(this, SiteActivity::class.java))
        }



    }
}