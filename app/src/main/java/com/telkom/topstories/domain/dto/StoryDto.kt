package com.telkom.topstories.domain.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StoryDto(
	val score: Int = 0 ,
	val by: String = "",
	val id: Int = 0 ,
	val time: String = "" ,
	val title: String = "",
	val type: String = "",
	val descendants: Int = 0 ,
	val url: String = "",
	val kids: List<Int> = listOf()
): Parcelable
