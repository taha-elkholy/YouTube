package com.troid.youtube.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.troid.youtube.*
import com.troid.youtube.pojo.Channel

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
}