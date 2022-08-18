package com.somar.moview;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActorResponse {

    @SerializedName("persons")
    private List<Actor> actors;

    public ActorResponse(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "ActorResponse{" +
                "actors=" + actors +
                '}';
    }
}
