package dev.ogabek.kotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.model.Filter

class FilterAdapter(var filters: List<Filter>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_EXPLORE_VIEW = 0
    private val TYPE_SIMPLE_VIEW = 1

    override fun getItemViewType(position: Int): Int {
        return if (filters[position].isExploreHave) {
            TYPE_EXPLORE_VIEW
        } else {
            TYPE_SIMPLE_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_SIMPLE_VIEW) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false)
            FilterViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_filter_explore, parent, false)
            FilterExploreViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = filters[position]
        if (holder is FilterViewHolder) {
            holder.tv_title.text = filter.title
            if (filter.isSelected) {
                holder.tv_title.setBackgroundResource(R.drawable.border_round_filter)
                holder.tv_title.setTextColor(Color.BLACK)
            } else {
                holder.tv_title.setBackgroundResource(R.drawable.border_round_filter_undone)
                holder.tv_title.setTextColor(Color.WHITE)
            }
        }
    }

    override fun getItemCount(): Int {
        return filters.size
    }

    private class FilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_title: TextView = view.findViewById(R.id.tv_filter_title)

    }

    private class FilterExploreViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}