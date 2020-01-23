package com.babaiyu.movieeks.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataType (
    var title: String,
    var release: String,
    var description: String,
    var score: String,
    var genre: Array<String>,
    var photo: Int
): Parcelable
