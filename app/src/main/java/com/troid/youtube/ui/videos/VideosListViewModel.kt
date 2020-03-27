package com.troid.youtube.ui.videos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.troid.youtube.pojo.response.ItemsItem
import com.troid.youtube.repository.VideoListRepository

class VideosListViewModel : ViewModel() {
    val videoListRepository: VideoListRepository = VideoListRepository()

    fun getVideos(channelId: String): LiveData<List<ItemsItem>> {
        return videoListRepository.getVideos(channelId)
    }

}
