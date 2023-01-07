package com.example.melobit.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Album{

	@SerializedName("image")
	private Image image;

	@SerializedName("artists")
	private List<ArtistsItem> artists;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("name")
	private String name;

	public Image getImage(){
		return image;
	}

	public List<ArtistsItem> getArtists(){
		return artists;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getName(){
		return name;
	}
}