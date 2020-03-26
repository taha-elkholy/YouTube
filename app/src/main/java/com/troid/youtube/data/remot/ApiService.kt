package com.troid.youtube.data.remot

import com.troid.youtube.pojo.response.VideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search") // endpoint
    fun getVideos(@Query("part") part: String, // snippet
                    @Query("channelId") channelId: String,  //UCsJRPfHLASyko7TKI2NXeCA
                    @Query("apiKey") apiKey:String) : Call<VideoResponse>
}