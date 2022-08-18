package com.somar.moview;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {

    private List<Review> reviews = new ArrayList<>();

    private static final String positiveType = "Позитивный";
    private static final String defaultType = "Нейтральный";

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.reviews_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewReviewName.setText(review.getAuthor());
        holder.textViewReviews.setText(review.getReview());
        String typeReview = review.getTypeReview();
        int backgroundColor;
        if (typeReview.equals(positiveType)) {
            backgroundColor = R.color.green;
        } else if (typeReview.equals(defaultType)) {
            backgroundColor = R.color.orange;
        } else {
            backgroundColor = R.color.red;
        }
        int background = ContextCompat.getColor(holder.itemView.getContext(), backgroundColor);
        holder.constraintLayoutBackground.setBackgroundColor(background);

        holder.textViewReviews.setOnClickListener(
                v -> holder.textViewReviews.setMaxLines(Integer.MAX_VALUE)
        );
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewReviewName;
        private final TextView textViewReviews;
        private final ConstraintLayout constraintLayoutBackground;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayoutBackground = itemView.findViewById(R.id.constraintLayoutBackground);
            textViewReviewName = itemView.findViewById(R.id.textViewReviewName);
            textViewReviews = itemView.findViewById(R.id.textViewReviews);
        }
    }
}
