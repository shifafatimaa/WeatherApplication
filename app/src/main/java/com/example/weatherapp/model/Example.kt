package com.example.weatherapp.model
import android.os.Parcel
import android.os.Parcelable

data class Example(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<DT>,
    val message: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(City::class.java.classLoader)!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.createTypedArrayList(DT.CREATOR)!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(city, flags)
        parcel.writeInt(cnt)
        parcel.writeString(cod)
        parcel.writeTypedList(list)
        parcel.writeInt(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Example> {
        override fun createFromParcel(parcel: Parcel): Example {
            return Example(parcel)
        }

        override fun newArray(size: Int): Array<Example?> {
            return arrayOfNulls(size)
        }
    }
}