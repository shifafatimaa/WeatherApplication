package com.example.weatherapp.model


import android.os.Parcel
import android.os.Parcelable

data class Sys(
    val pod: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sys> {
        override fun createFromParcel(parcel: Parcel): Sys {
            return Sys(parcel)
        }

        override fun newArray(size: Int): Array<Sys?> {
            return arrayOfNulls(size)
        }
    }
}