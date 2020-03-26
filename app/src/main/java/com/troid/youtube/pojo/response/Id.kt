package com.troid.youtube.pojo.response

import com.google.gson.annotations.SerializedName

data class Id(

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("videoId")
	val videoId: String? = null
)