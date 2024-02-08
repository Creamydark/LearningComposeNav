package com.creamydark.learningcomposenav.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID


@Parcelize
data class User(
    val name:String = "",
    val cpNumber:String = "",
    val id :String = UUID.randomUUID().toString()
) : Parcelable
