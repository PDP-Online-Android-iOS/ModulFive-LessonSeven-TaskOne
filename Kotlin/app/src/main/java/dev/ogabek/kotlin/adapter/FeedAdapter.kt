package dev.ogabek.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.model.Feed

class FeedAdapter(private val feeds: List<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedVideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed: Feed = feeds[position]
        if (holder is FeedVideoViewHolder) {
            holder.iv_video.setImageResource(feed.picture)
            holder.iv_profile.setImageResource(feed.profilePhoto)
            holder.tv_title.text = feed.title
            holder.tv_time.text = feed.time
            holder.tv_description.text = feed.description
        }
    }

    override fun getItemCount(): Int {
        return feeds.size
    }

    private class FeedVideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_video: ImageView = view.findViewById(R.id.iv_video_photo)
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_video_profile)
        var tv_title: TextView = view.findViewById(R.id.tv_title)
        var tv_description: TextView = view.findViewById(R.id.tv_video_about)
        var tv_time: TextView = view.findViewById(R.id.tv_video_time)
    }
}