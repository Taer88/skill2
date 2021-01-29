package com.anydog.qaedu.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.data.model.api.data.CommentItem;
import com.anydog.qaedu.data.model.api.data.Product;
import com.anydog.qaedu.data.model.api.data.SubCommentItem;
import com.anydog.qaedu.ui.custom.AvatarImageView;
import com.anydog.qaedu.ui.custom.CircleImageView;
import com.anydog.qaedu.ui.feed.bucket.BucketAdapter;
import com.anydog.qaedu.ui.feed.products.ProductsAdapter;
import com.anydog.qaedu.ui.product.comments.CommentsAdapter;
import com.anydog.qaedu.ui.product.comments.SubCommentsAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addBucketItems(RecyclerView recyclerView, List<BucketItem> items) {
        BucketAdapter adapter = (BucketAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(items);
        }
    }

//    @BindingAdapter({"adapter"})
//    public static void addBucketItems(RecyclerView recyclerView, List<SubCommentItem> items) {
//        SubCommentsAdapter adapter = (SubCommentsAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.clearItems();
//            adapter.addItems(items);
//        }
//    }

    @BindingAdapter({"adapter"})
    public static void addCommentsItems(RecyclerView recyclerView, List<CommentItem> items) {
        CommentsAdapter adapter = (CommentsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(items);
        }
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, Integer resource) {
        imageView.setImageResource(resource);
    }

    @BindingAdapter("price")
    public static void setPrice(TextView cardView, Float price) {
        if (price != null){
            cardView.setText(price.toString() + "$");
        }
    }

    @BindingAdapter("discount")
    public static void setImageAction(View cardView, boolean isAction) {
        if (isAction) {
            cardView.setBackgroundColor(Color.parseColor("#d34836"));
        } else {
            cardView.setBackgroundColor(Color.parseColor("#78DC96"));
        }
    }

    @BindingAdapter({"adapter"})
    public static void addProductsItem(RecyclerView recyclerView, List<Product> tickets) {
        try {
            ProductsAdapter adapter = (ProductsAdapter) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.clearItems();
                adapter.addItems(tickets);
            }
        } catch (Exception e) {

        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    @BindingAdapter("avatarUrl")
    public static void setAvatarUrl(AvatarImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    @BindingAdapter("avatarUrl")
    public static void setAvatarUrl(CircleImageView imageView, String url) {
            Context context = imageView.getContext();
            Glide.with(context).load(url).into(imageView);
    }
}
