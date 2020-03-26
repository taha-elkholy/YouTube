package com.troid.youtube.ui.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.troid.youtube.R
import com.troid.youtube.adapter.ChannelsAdapter
import com.troid.youtube.databinding.FragmentChannelsBinding
import com.troid.youtube.pojo.Channel


class ChannelsFragment : Fragment() {

    private lateinit var channelsViewModel: ChannelsViewModel
    private lateinit var binding: FragmentChannelsBinding
    private lateinit var adapter: ChannelsAdapter
    private lateinit var navigation: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_channels, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        channelsViewModel = ViewModelProvider(this).get(ChannelsViewModel::class.java)
        navigation = Navigation.findNavController(view)
        adapter = ChannelsAdapter()
        adapter.setOnItemClickListener(object : ChannelsAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, item: Channel) {
                val bundle = Bundle()
                bundle.putString("channelId", item.channelId)
                navigation.navigate(R.id.action_channelsFragment_to_videosListFragment,bundle)
            }

        })
        binding.channelsRecyclerView.adapter = adapter
    }


    override fun onStart() {
        super.onStart()
        // observe data from viewModel
        channelsViewModel.channels.observe(viewLifecycleOwner, Observer {
            adapter.swapData(it)
        })

        binding.invalidateAll()
    }
}
