package com.troid.youtube.ui.channels

import androidx.lifecycle.ViewModel
import com.troid.youtube.repository.ChannelRepository

class ChannelsViewModel : ViewModel() {
    var respository : ChannelRepository = ChannelRepository()

    val channels = respository.getChannelsList()
}
