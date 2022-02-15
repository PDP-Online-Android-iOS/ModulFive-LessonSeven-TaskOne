package dev.ogabek.java.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Filter;

public class FilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_EXPLORE_VIEW = 0;
    private static final int TYPE_SIMPLE_VIEW = 1;

    List<Filter> filters;

    public FilterAdapter(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public int getItemViewType(int position) {
        if (filters.get(position).isExploreHave()) {
            return TYPE_EXPLORE_VIEW;
        } else {
            return TYPE_SIMPLE_VIEW;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_SIMPLE_VIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_filter, parent, false);
            return new FilterViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_explore, parent, false);
            return new FilterExploreViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Filter filter = filters.get(position);

        if (holder instanceof FilterViewHolder) {
            ((FilterViewHolder) holder).tv_title.setText(filter.getTitle());
            if (filter.isSelected()) {
                ((FilterViewHolder) holder).tv_title.setBackgroundResource(R.drawable.border_round_filter);
                ((FilterViewHolder) holder).tv_title.setTextColor(Color.BLACK);
            } else {
                ((FilterViewHolder) holder).tv_title.setBackgroundResource(R.drawable.border_round_filter_undone);
                ((FilterViewHolder) holder).tv_title.setTextColor(Color.WHITE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    private static class FilterViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;

        public FilterViewHolder(View view) {
            super(view);

            tv_title = view.findViewById(R.id.tv_filter_title);

        }
    }

    private static class FilterExploreViewHolder extends RecyclerView.ViewHolder {
        public FilterExploreViewHolder(View view) {
            super(view);
        }
    }
}
