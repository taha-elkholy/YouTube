package com.troid.youtube.repository

import android.content.res.Resources
import android.provider.Settings.Secure.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.troid.youtube.*
import com.troid.youtube.data.remot.ApiManager
import com.troid.youtube.pojo.Channel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChannelRepository {

    fun getChannelsList(): LiveData<List<Channel>>{
        val channelsLiveData = MutableLiveData<List<Channel>>()

        val channels = listOf<Channel>(
            Channel(R.drawable.afasy,"Mishary AlAfasy", AFASY ),
            Channel(R.drawable.eldaheh,"El Daheh", ELDAHEH ),
            Channel(R.drawable.espitalia, "Espitalia", ESPITALIA ),
            Channel(R.drawable.mbc, "MBC", MBC_ROOTS ),
            Channel(R.drawable.muscle_clinic, "Muscle Clinic", MUSCLE_CLINIC )
        )
        channelsLiveData.postValue(channels)
        return channelsLiveData

    }
//    fun getChannels(): LiveData<List<Channel>> {
//        val channelsLiveData = MutableLiveData<List<Channel>>()
//        ApiManager.apiService.getChannels(API_KEY)
//            .enqueue(object : Callback<Channel>{
//                override fun onFailure(call: Call<Channel>, t: Throwable) {
//                    t.printStackTrace()
//                }
//
//                override fun onResponse(call: Call<Channel>, response: Response<Channel>) {
//                    response.body()?.let {
//                        channelsLiveData.postValue(listOf(it))
//                    }
//                }
//            })
//        return channelsLiveData
//    }
}