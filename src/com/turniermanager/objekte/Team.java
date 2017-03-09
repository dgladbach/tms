package com.turniermanager.objekte;

public class Team {
	private String uuid;
	private String name;
	private String picture;
	private String description;
	private int status;

	/**
	 * Create a team with values from db
	 * 
	 * @param uuid
	 * @param name
	 * @param picture
	 * @param description
	 * @param status
	 */
	public Team(String uuid, String name, String picture, String description, int status) {
		this.uuid = uuid;
		this.name = name;
		this.picture = picture;
		this.description = description;
		this.status = status;
	}

	/**
	 * Create a new Team to store in db
	 * 
	 * @param uuid
	 * @param name
	 * @param picture
	 * @param description
	 */
	public Team(String uuid, String name, String picture, String description) {
		this.uuid = uuid;
		this.name = name;
		this.picture = picture;
		this.description = description;
		this.status = 0;
	}

	public String getUUID() {
		return this.uuid;
	}

	public String getName() {
		return this.name;
	}

	public String getPicture() {
		return this.picture;
	}

	public String getDescription() {
		return this.description;
	}

	public int getStatus() {
		return this.status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
