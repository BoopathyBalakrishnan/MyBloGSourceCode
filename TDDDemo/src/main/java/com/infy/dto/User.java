package com.infy.dto;

public class User {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacebookid() {
		return facebookid;
	}

	public void setFacebookid(String facebookid) {
		this.facebookid = facebookid;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getUserPreferenceHistoryId() {
		return userPreferenceHistoryId;
	}

	public void setUserPreferenceHistoryId(int userPreferenceHistoryId) {
		this.userPreferenceHistoryId = userPreferenceHistoryId;
	}

	public int getUserItemHistoryId() {
		return userItemHistoryId;
	}

	public void setUserItemHistoryId(int userItemHistoryId) {
		this.userItemHistoryId = userItemHistoryId;
	}

	public Boolean getLuxury() {
		return luxury;
	}

	public void setLuxury(Boolean luxury) {
		this.luxury = luxury;
	}

	public Boolean getLatest() {
		return latest;
	}

	public void setLatest(Boolean latest) {
		this.latest = latest;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private int id;
	private String facebookid;
	private Integer age = 18;
	private String currentLocation = "US";
	private String origin = "AMERICAN";
	private Boolean luxury = true;
	private Boolean latest = true;
	private String gender = "Male";
	private int userPreferenceHistoryId;
	private int userItemHistoryId;
	private int friendId;

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public int getFriendId() {
		return this.friendId;
	}
}
