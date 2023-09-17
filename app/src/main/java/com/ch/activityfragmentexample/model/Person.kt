package com.ch.activityfragmentexample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Person(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val job: String,
    val profileDesc: String,
    val profilePictUrl: String
): Parcelable
