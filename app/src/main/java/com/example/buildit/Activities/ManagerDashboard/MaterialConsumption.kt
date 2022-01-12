package com.example.buildit.Activities.ManagerDashboard

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.buildit.Activities.SiteActivities.AddSiteActivity
import com.example.buildit.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MaterialConsumption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_consumption)

       val material_type = findViewById<TextInputEditText>(R.id.type_TextField)
       val material_requirement = findViewById<TextInputEditText>(R.id.Required_TextField)

        val name_site = intent.getStringExtra("Name")?:""

        val add_material_cons_btn = findViewById<Button>(R.id.add_material)


       val database = Firebase.database.getReference("Users/${Firebase.auth.uid}")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                material_type.setText(snapshot.child("Material Type").value.toString())
                material_requirement.setText(snapshot.child("Material Requirement").value.toString())



            }


            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })

        add_material_cons_btn.setOnClickListener {


            updateData(material_type.text.toString(), material_requirement.text.toString(), name_site.toString())

            val intent = Intent(this,ManagerDashboard::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG,"name info" +name_site)

        }


    }

    private fun updateData(material_type: String, material_requirement: String, name_site: String) {
        val database = Firebase.database.reference
        val key = database.child("Users").push().key
        val user_data = materialconsdata(material_type, material_requirement)
        val data = user_data.toMap()
        val userupdates = hashMapOf<String, Any>("Users/${Firebase.auth.uid}/$name_site/Material Consumption/$key" to data)
        database.updateChildren(userupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, ManagerDashboard::class.java))

        }


    }
}