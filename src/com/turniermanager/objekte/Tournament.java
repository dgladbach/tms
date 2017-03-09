package com.turniermanager.objekte;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Tournament {
	private String uuid;
	private String name;
	private Leader owner;
	private String comment;
	private String accesscode;
	private int status;
	private Timestamp cdate;
	private ArrayList<Team> teamList;

	/**
	 * Create a tournament object with values from db
	 * 
	 * @param uuid
	 * @param name
	 * @param owner
	 * @param comment
	 * @param accesscode
	 * @param status
	 * @param cdate
	 */
	public Tournament(String uuid, String name, Leader owner, String comment, String accesscode, int status,
			Timestamp cdate) {
		this.uuid = uuid;
		this.name = name;
		this.owner = owner;
		this.comment = comment;
		this.accesscode = accesscode;
		this.status = status;
		this.cdate = cdate;
	}
	
	/**
	 * Create a tournament object with teamList with values from db
	 * 
	 * @param uuid
	 * @param name
	 * @param owner
	 * @param comment
	 * @param accesscode
	 * @param status
	 * @param cdate
	 */
	public Tournament(String uuid, String name, Leader owner, String comment, String accesscode, int status,
			Timestamp cdate, ArrayList<Team> teamList) {
		this.uuid = uuid;
		this.name = name;
		this.owner = owner;
		this.comment = comment;
		this.accesscode = accesscode;
		this.status = status;
		this.cdate = cdate;
		this.teamList = teamList;
	}

	/**
	 * Create a new tournament to store in db
	 * 
	 * @param name
	 * @param owner
	 * @param comment
	 */
	public Tournament(String uuid, String name, Leader owner, String comment) {
		this.name = name;
		this.owner = owner;
		this.comment = comment;
		this.status = 0;
		this.cdate = new Timestamp(System.currentTimeMillis());
		this.uuid = uuid;
	}

	public String getUUID() {
		return this.uuid;
	}

	public String getName() {
		return this.name;
	}

	public Leader getOwner() {
		return this.owner;
	}

	public String getComment() {
		return this.comment;
	}

	public String getAccesscode() {
		return this.accesscode;
	}

	public int getStatus() {
		return this.status;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public Team getTeam(String uuid) {
		for (Team t : teamList) {
			if (t.getUUID().equals(uuid)) {
				return t;
			}
		}
		return null;
	}

	public ArrayList<Team> getTeamList() {
		return this.teamList;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void addTeam(Team team) {
		if (!teamList.contains(team)) {
			this.teamList.add(team);
		}
	}

	public void removeTeam(String uuid){
		for(Team t : teamList){
			if (t.getUUID().equals(uuid)){
				teamList.remove(t);
			}
		}
	}

}
