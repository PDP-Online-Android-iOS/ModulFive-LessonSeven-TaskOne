package dev.ogabek.java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Feed;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Feed> feeds;

    public FeedAdapter(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_video, parent, false);
        return new FeedVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Feed feed = feeds.get(position);

        if (holder instanceof FeedVideoViewHolder) {
            ((FeedVideoViewHolder) holder).iv_video.setImageResource(feed.getPicture());
            ((FeedVideoViewHolder) holder).iv_profile.setImageResource(feed.getProfilePhoto());
            ((FeedVideoViewHolder) holder).tv_title.setText(feed.getTitle());
            ((FeedVideoViewHolder) holder).tv_time.setText(feed.getTime());
            ((FeedVideoViewHolder) holder).tv_description.setText(feed.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    private static class FeedVideoViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_video, iv_more;
        ShapeableImageView iv_profile;
        TextView tv_title, tv_description, tv_time;

        public FeedVideoViewHolder(View view) {
            super(view);

            iv_profile = view.findViewById(R.id.iv_video_profile);
            iv_video = view.findViewById(R.id.iv_video_photo);
            tv_title = view.findViewById(R.id.tv_title);
            tv_description = view.findViewById(R.id.tv_video_about);
            tv_time = view.findViewById(R.id.tv_video_time);
            iv_video = view.findViewById(R.id.iv_video_photo);
            iv_more = view.findViewById(R.id.iv_video_more);

        }
    }
}
