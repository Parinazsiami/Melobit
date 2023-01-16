package com.example.melobit.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Song {

	@SerializedName("duration")
	private int duration;

	@SerializedName("hasVideo")
	private boolean hasVideo;

	@SerializedName("copyrighted")
	private boolean copyrighted;

	@SerializedName("image")
	private Image image;

	@SerializedName("artists")
	private List<Artist> artists;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("album")
	private Album album;

	@SerializedName("localized")
	private boolean localized;

	@SerializedName("id")
	private String id;

	@SerializedName("audio")
	private Audio audio;

	@SerializedName("title")
	private String title;

	@SerializedName("downloadCount")
	private String downloadCount;

	public int getDuration(){
		return duration;
	}

	public boolean isHasVideo(){
		return hasVideo;
	}

	public boolean isCopyrighted(){
		return copyrighted;
	}

	public Image getImage(){
		return image;
	}

	public List<Artist> getArtists(){
		return artists;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public Album getAlbum(){
		return album;
	}

	public boolean isLocalized(){
		return localized;
	}

	public String getId(){
		return id;
	}

	public Audio getAudio(){
		return audio;
	}

	public String getTitle(){
		return title;
	}

	public String getDownloadCount(){
		return downloadCount;
	}
}