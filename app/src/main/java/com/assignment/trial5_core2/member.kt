package com.assignment.trial5_core2


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class member( val name: String, val stagename: String,
                   val nickname: String, val age: Int, val Role: String, val knownFor: String,
                   var rating : Int, val img : String, var KnowHim: Boolean): Parcelable
{
}