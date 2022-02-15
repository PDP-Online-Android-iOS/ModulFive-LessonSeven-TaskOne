package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.adapter.FeedAdapter
import dev.ogabek.kotlin.adapter.FilterAdapter
import dev.ogabek.kotlin.model.Feed
import dev.ogabek.kotlin.model.Filter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerFeed: RecyclerView
    private lateinit var recyclerFilter: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFeed.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        recyclerFilter.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        refreshFeedAdapter(allFeeds())
        refreshFilterAdapter(allFilters())
    }

    private fun refreshFeedAdapter(feeds: List<Feed>) {
        recyclerFeed.adapter = FeedAdapter(feeds)
    }

    private fun allFeeds(): List<Feed> {
        val feeds: MutableList<Feed> = ArrayList<Feed>()
        feeds.add(
            Feed(
                R.drawable.i,
                R.drawable.video_img,
                "45:54",
                getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy),
                getString(R.string.ogabekdev_73_views_2_weeks_ago)
            )
        )
        feeds.add(
            Feed(
                R.drawable.i,
                R.drawable.video_img,
                "45:54",
                getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy),
                getString(R.string.ogabekdev_73_views_2_weeks_ago)
            )
        )
        feeds.add(
            Feed(
                R.drawable.i,
                R.drawable.video_img,
                "45:54",
                getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy),
                getString(R.string.ogabekdev_73_views_2_weeks_ago)
            )
        )
        feeds.add(
            Feed(
                R.drawable.i,
                R.drawable.video_img,
                "45:54",
                getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy),
                getString(R.string.ogabekdev_73_views_2_weeks_ago)
            )
        )
        return feeds
    }

    private fun refreshFilterAdapter(filter: List<Filter>) {
        recyclerFilter.adapter = FilterAdapter(filter)
    }

    private fun allFilters(): List<Filter> {
        val filters: MutableList<Filter> = ArrayList<Filter>()
        filters.add(Filter(true, false))
        filters.add(Filter("All", true))
        filters.add(Filter("OgabekDev", false))
        filters.add(Filter("PDP", false))
        filters.add(Filter("Android", false))
        filters.add(Filter("Events", false))
        filters.add(Filter("Android", false))
        filters.add(Filter("Mobile", false))
        return filters
    }
}