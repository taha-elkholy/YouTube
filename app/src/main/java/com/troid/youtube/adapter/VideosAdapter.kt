package com.troid.youtube.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.troid.youtube.R
import com.troid.youtube.pojo.response.ItemsItem
import kotlinx.android.synthetic.main.channel_list_item.view.*

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {

    // List of data 
    private var data: List<ItemsItem> = listOf()

    // private variable from onItemClickListener
    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.channel_list_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) =
        holder.bind(data[position])

    // to get data many times in runtime
    fun swapData(data: List<ItemsItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemsItem) = with(itemView) {

            channelNameTextView.text = item.snippet?.title
            setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener!!.onItemClick(item, adapterPosition)
                }
            }
        }
    }

    // setter function for the onItemClickListener
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    /* Interface to listen for Clicks */
    interface OnItemClickListener {
        // what you need for return from the item
        fun onItemClick(item: ItemsItem, position: Int)
    }
}