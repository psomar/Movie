package com.somar.moview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorViewHolder> {

    private List<Actor> actors = new ArrayList<>();

    public void setActors(List<Actor> actors) {
        this.actors = actors;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (
                        R.layout.person_item,
                        parent,
                        false
                );
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        Actor actor = actors.get(position);
        Glide.with(holder.itemView)
                .load(actor.getPhoto())
                .into(holder.imageViewPerson);
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    static class ActorViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewPerson;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPerson = itemView.findViewById(R.id.imageViewPerson);
        }
    }
}
