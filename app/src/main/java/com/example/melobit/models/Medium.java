package com.example.melobit.models;

import com.google.gson.annotations.SerializedName;

public class Medium{

	@SerializedName("fingerprint")
	private String fingerprint;

	@SerializedName("url")
	private String url;

	public String getFingerprint(){
		return fingerprint;
	}

	public String getUrl(){
		return url;
	}
}