package com.bynder.sdk.model;

import com.bynder.sdk.query.ApiField;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SavedMediaResponse {

	@SerializedName("mediaid")
	private String mediaId;

	private String batchId;

	private boolean success;

	@SerializedName("mediaitems")
	private List<SavedMediaItemResponse> mediaItems;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<SavedMediaItemResponse> getMediaItems() {
		return mediaItems;
	}

	public void setMediaItems(List<SavedMediaItemResponse> mediaItems) {
		this.mediaItems = mediaItems;
	}
}
