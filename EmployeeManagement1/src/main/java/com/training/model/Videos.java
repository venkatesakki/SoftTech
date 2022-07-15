package com.training.model;

public class Videos 
{
	private String videoId;
	private String videoName;
	private int durationInMin;
	private int durationInSec;
	private String url;
	
	public Videos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Videos(String videoId, String videoName, int durationInMin, int durationInSec, String url) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.durationInMin = durationInMin;
		this.durationInSec = durationInSec;
		this.url = url;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public int getDurationInMin() {
		return durationInMin;
	}
	public void setDurationInMin(int durationInMin) {
		this.durationInMin = durationInMin;
	}
	public int getDurationInSec() {
		return durationInSec;
	}
	public void setDurationInSec(int durationInSec) {
		this.durationInSec = durationInSec;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Videos [videoId=" + videoId + ", videoName=" + videoName + ", durationInMin=" + durationInMin
				+ ", durationInSec=" + durationInSec + ", url=" + url + "]";
	}
}
