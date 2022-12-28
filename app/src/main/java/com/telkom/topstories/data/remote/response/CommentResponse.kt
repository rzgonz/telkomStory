package com.telkom.topstories.data.remote.response

import com.google.gson.annotations.SerializedName

data class CommentResponse(

	@field:SerializedName("parent")
	val parent: Int? = null,

	@field:SerializedName("by")
	val by: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("time")
	val time: Long? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("kids")
	val kids: List<Int?>? = null
)
