package com.anydog.qaedu.ui.product.comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anydog.qaedu.R;
import com.anydog.qaedu.data.model.api.data.SubCommentItem;

import java.util.List;

public class SubCommentsAdapter extends RecyclerView.Adapter<SubCommentsAdapter.ViewHolder> {
    private List<SubCommentItem> data;

    public SubCommentsAdapter(List<SubCommentItem> myDataset) {
        data = myDataset;
    }

    @NonNull
    @Override
    public SubCommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subcomment_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getText());
        holder.userNameView.setText(data.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView userNameView;

        ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.scText);
            userNameView = v.findViewById(R.id.scUsername);
        }
    }
}
