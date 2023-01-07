package com.example.melobit.models;

import com.google.gson.annotations.SerializedName;

public class Slider{

	@SerializedName("url")
	private String url;

	public String getUrl(){
		return url;
	}
}