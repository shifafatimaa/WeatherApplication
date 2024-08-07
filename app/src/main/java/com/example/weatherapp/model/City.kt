package com.example.weatherapp.model
import android.os.Parcel
import android.os.Parcelable

data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Coord::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(coord, flags)
        parcel.writeString(country)
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(population)
        parcel.writeInt(sunrise)
        parcel.writeInt(sunset)
        parcel.writeInt(timezone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }
    }
}