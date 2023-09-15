package com.ch.activityfragmentexample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String,
    val job: String,
    val profileDesc: String,
    val profilePictUrl: String
): Parcelable
