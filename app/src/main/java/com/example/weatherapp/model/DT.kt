package com.example.weatherapp.model

import android.os.Parcel
import android.os.Parcelable



data class DT(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Clouds::class.java.classLoader)!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readParcelable(Main::class.java.classLoader)!!,
        parcel.readDouble(),
        parcel.readParcelable(Rain::class.java.classLoader)!!,
        parcel.readParcelable(Sys::class.java.classLoader)!!,
        parcel.readInt(),
        parcel.createTypedArrayList(Weather.CREATOR)!!,
        parcel.readParcelable(Wind::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(clouds, flags)
        parcel.writeInt(dt)
        parcel.writeString(dt_txt)
        parcel.writeParcelable(main, flags)
        parcel.writeDouble(pop)
        parcel.writeParcelable(rain, flags)
        parcel.writeParcelable(sys, flags)
        parcel.writeInt(visibility)
        parcel.writeTypedList(weather)
        parcel.writeParcelable(wind, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DT> {
        override fun createFromParcel(parcel: Parcel): DT {
            return DT(parcel)
        }

        override fun newArray(size: Int): Array<DT?> {
            return arrayOfNulls(size)
        }
    }
}
