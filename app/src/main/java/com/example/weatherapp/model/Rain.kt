package com.example.weatherapp.model
import android.os.Parcel
import android.os.Parcelable

data class Rain(
    val `3h`: Double
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(`3h`)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rain> {
        override fun createFromParcel(parcel: Parcel): Rain {
            return Rain(parcel)
        }

        override fun newArray(size: Int): Array<Rain?> {
            return arrayOfNulls(size)
        }
    }
}