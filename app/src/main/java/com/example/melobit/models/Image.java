package com.example.melobit.models;

import com.google.gson.annotations.SerializedName;

public class Image{

	@SerializedName("thumbnail_small")
	private ThumbnailSmall thumbnailSmall;

	@SerializedName("cover")
	private Cover cover;

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("cover_small")
	private CoverSmall coverSmall;

	@SerializedName("slider")
	private Slider slider;

	public ThumbnailSmall getThumbnailSmall(){
		return thumbnailSmall;
	}

	public Cover getCover(){
		return cover;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public CoverSmall getCoverSmall(){
		return coverSmall;
	}

	public Slider getSlider(){
		return slider;
	}
}