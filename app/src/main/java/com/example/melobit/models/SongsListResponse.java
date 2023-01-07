package com.example.melobit.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SongsListResponse {

	@SerializedName("total")
	private int total;

	@SerializedName("results")
	private List<Song> results;

	public int getTotal(){
		return total;
	}

	public List<Song> getResults(){
		return results;
	}
}