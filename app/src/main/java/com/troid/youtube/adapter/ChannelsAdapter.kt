package com.troid.youtube.adapter

import android.view.LayoutInflater
import com.troid.youtube.R
import com.troid.youtube.pojo.Channel

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.channel_list_item.view.*

class ChannelsAdapter : RecyclerView.Adapter<ChannelsAdapter.ChannelsViewHolder>() {

    // List of data 
    private var data: List<Channel> = listOf()

    // private variable from onItemClickListener
    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelsViewHolder {
        return ChannelsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.channel_list_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ChannelsViewHolder, position: Int) =
        holder.bind(data[position])

    // to get data many times in runtime
    fun swapData(data: List<Channel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ChannelsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Channel) = with(itemView) {

            channelNameTextView.text = item.name
            ChannelImageView.setImageResource(item.image)
//            Glide.with(itemView).load(item.image).placeholder(R.color.colorAccent)
//                .error(R.color.colorPrimary)
//                .into(ChannelImageView)
            setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener!!.onItemClick(adapterPosition, item)
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
        fun onItemClick(position: Int, item: Channel)
    }
}