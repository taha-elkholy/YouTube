package com.troid.youtube.pojo.response

import com.google.gson.annotations.SerializedName

data class High(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)