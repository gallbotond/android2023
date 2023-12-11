package com.example.foodapp.model

import android.os.Parcel
import android.os.Parcelable

data class RecipeModel(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
//    val tags: List<TagModel>,
    val rating: Float,
//    val credits: List<CreditModel>,
//    val sections: List<SectionModel>,
//    val topics: List<TopicModel>,
//    val instructions: List<InstructionModel>,
//    val nutrition: NutritionModel,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(description)
        parcel.writeFloat(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecipeModel> {
        override fun createFromParcel(parcel: Parcel): RecipeModel {
            return RecipeModel(parcel)
        }

        override fun newArray(size: Int): Array<RecipeModel?> {
            return arrayOfNulls(size)
        }
    }
}
