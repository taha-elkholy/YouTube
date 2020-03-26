package com.troid.youtube.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.troid.youtube.MY_API_KEY
import com.troid.youtube.data.remot.ApiManager
import com.troid.youtube.pojo.response.ItemsItem
import com.troid.youtube.pojo.response.VideoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoListRepository {

    fun getVideos(channelId: String): LiveData<List<ItemsItem>> {
        val videosLiveData = MutableLiveData<List<ItemsItem>>()
        ApiManager.apiService.getVideos("snippet",channelId, MY_API_KEY)
            .enqueue(object : Callback<VideoResponse>{
                override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<VideoResponse>,
                    response: Response<VideoResponse>
                ) {
                    response.body()?.items.let {
                        Log.v("do", "done ${it?.size}") // it null

                        videosLiveData.postValue(it as? List<ItemsItem>)
                    }
                }
            })

        return videosLiveData
    }

}