package com.example.buildit.Activities.SiteActivities

import com.google.firebase.database.Exclude

data class userdata (
    var name: String? = "",
    var address: String? = "",



) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Name" to name,
            "Address" to address,

        )
    }
}