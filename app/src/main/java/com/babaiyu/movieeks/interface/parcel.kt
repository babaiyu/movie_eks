package com.babaiyu.movieeks.`interface`

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataDetail (
    var title: String,
    var release: String,
    var description: String,
    var score: String,
    var duration: String,
    var director: String,
    var caster: String,
    var photo: Int
): Parcelable

@Parcelize
data class MovieList(
    var title: String,
    var release: String,
    var description: String,
    var photo: Int
): Parcelable
