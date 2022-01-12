package com.example.buildit.Activities.SiteActivities

import com.google.firebase.database.Exclude

data class SiteUserData (val Name: String ,
                         val Address :String)


{
        constructor():this("","")
    @Exclude
    fun toMap():Map<String,Any?>{

        return mapOf(
            Name to Name,
            Address to Address
        )

        fun getname_siteUsers():String?{
            return Name
        }

        fun getaddress_sitrUsers():String?{
            return Address
        }
    }
}