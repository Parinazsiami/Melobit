package com.example.melobit.models;

import com.google.gson.annotations.SerializedName;

public class Audio{

	@SerializedName("high")
	private High high;

	@SerializedName("medium")
	private Medium medium;

	public High getHigh(){
		return high;
	}

	public Medium getMedium(){
		return medium;
	}
}