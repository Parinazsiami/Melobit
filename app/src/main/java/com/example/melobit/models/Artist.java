package com.example.melobit.models;

import com.google.gson.annotations.SerializedName;

public class Artist {

	@SerializedName("image")
	private Image image;

	@SerializedName("fullName")
	private String fullName;

	@SerializedName("sumSongsDownloadsCount")
	private String sumSongsDownloadsCount;

	@SerializedName("id")
	private String id;

	@SerializedName("followersCount")
	private int followersCount;

	@SerializedName("type")
	private String type;

	public Image getImage(){
		return image;
	}

	public String getFullName(){
		return fullName;
	}

	public String getSumSongsDownloadsCount(){
		return sumSongsDownloadsCount;
	}

	public String getId(){
		return id;
	}

	public int getFollowersCount(){
		return followersCount;
	}

	public String getType(){
		return type;
	}
}