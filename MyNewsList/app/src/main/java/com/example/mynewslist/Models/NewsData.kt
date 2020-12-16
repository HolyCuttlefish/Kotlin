package com.example.mynewslist.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsData(val name : String, val url : String, val author : String, val content : String) : Parcelable