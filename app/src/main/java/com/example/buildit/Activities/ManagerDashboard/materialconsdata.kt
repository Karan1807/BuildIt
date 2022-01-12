package com.example.buildit.Activities.ManagerDashboard

import com.google.firebase.database.Exclude

class materialconsdata (
    var Type: String? = "",
    var Requirement: String? = "",




    ) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Type" to Type,
            "Requirement" to Requirement,


            )
    }
}