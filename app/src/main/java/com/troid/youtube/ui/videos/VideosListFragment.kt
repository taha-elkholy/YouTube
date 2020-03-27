package com.troid.youtube.ui.videos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.troid.youtube.R
import com.troid.youtube.adapter.VideosAdapter
import com.troid.youtube.pojo.response.ItemsItem
import kotlinx.android.synthetic.main.list_item.*

class VideosListFragment : Fragment() {


    private lateinit var adapter: VideosAdapter
    private lateinit var viewModel: VideosListViewModel
    private lateinit var videoLink: String
    private lateinit var channelId: String
    private lateinit var navigation: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.list_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
         navigation = Navigation.findNavController(view)
        if (bundle != null) {
            channelId = bundle.getString("channelId").toString()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideosListViewModel::class.java)

        adapter = VideosAdapter()
        adapter.setOnItemClickListener(object : VideosAdapter.OnItemClickListener{
            override fun onItemClick(item: ItemsItem, position: Int) {
                val bundle = Bundle()
                videoLink = item.id?.videoId.toString()
                bundle.putString("videoLink",videoLink)
                navigation.navigate(R.id.action_videosListFragment_to_playVideoFragment,bundle)

            }

        })
        videoRecyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.getVideos(channelId).observe(viewLifecycleOwner, Observer {
            adapter.swapData(it)
        })

    }
}
