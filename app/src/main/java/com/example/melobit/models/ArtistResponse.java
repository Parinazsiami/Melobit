package com.example.melobit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistResponse {
    @SerializedName("total")
    private int total;

    @SerializedName("results")
    private List<Artist> results;

    public int getTotal(){
        return total;
    }

    public List<Artist> getResults(){
        return results;
    }
}
