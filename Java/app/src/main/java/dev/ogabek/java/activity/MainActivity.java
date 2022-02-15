package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.adapter.FeedAdapter;
import dev.ogabek.java.adapter.FilterAdapter;
import dev.ogabek.java.model.Feed;
import dev.ogabek.java.model.Filter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerFeed, recyclerFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerFeed = findViewById(R.id.recyclerFeed);
        recyclerFilter = findViewById(R.id.recyclerFilter);

        recyclerFeed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerFilter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        refreshFeedAdapter(getAllFeeds());
        refreshFilterAdapter(getAllFilters());
    }

    private void refreshFeedAdapter(List<Feed> feeds) {
        recyclerFeed.setAdapter(new FeedAdapter(feeds));
    }

    private List<Feed> getAllFeeds() {
        List<Feed> feeds = new ArrayList<>();

        feeds.add(new Feed(R.drawable.i, R.drawable.video_img, "45:54", getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy), getString(R.string.ogabekdev_73_views_2_weeks_ago)));
        feeds.add(new Feed(R.drawable.i, R.drawable.video_img, "45:54", getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy), getString(R.string.ogabekdev_73_views_2_weeks_ago)));
        feeds.add(new Feed(R.drawable.i, R.drawable.video_img, "45:54", getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy), getString(R.string.ogabekdev_73_views_2_weeks_ago)));
        feeds.add(new Feed(R.drawable.i, R.drawable.video_img, "45:54", getString(R.string.android_guruhi_talabalari_mobile_ilova_loyihasi_taqdimoti_unicorn_by_pdp_academy), getString(R.string.ogabekdev_73_views_2_weeks_ago)));

        return feeds;
    }

    private void refreshFilterAdapter(List<Filter> filter) {
        recyclerFilter.setAdapter(new FilterAdapter(filter));
    }

    private List<Filter> getAllFilters() {
        List<Filter> filters = new ArrayList<>();

        filters.add(new Filter(true, false));

        filters.add(new Filter("All", true));
        filters.add(new Filter("OgabekDev", false));
        filters.add(new Filter("PDP", false));
        filters.add(new Filter("Android", false));
        filters.add(new Filter("Events", false));
        filters.add(new Filter("Android", false));
        filters.add(new Filter("Mobile", false));

        return filters;
    }
}