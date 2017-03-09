package com.turniermanager.objekte;

public class Leader {
	String uuid;
	String name;
	String loginname;

	public Leader(String uuid, String name, String loginname) {
		this.uuid = uuid;
		this.name = name;
		this.loginname = loginname;
	}

	public String getUUID() {
		return this.uuid;
	}

	public String getName() {
		return this.name;
	}

	public String getLoginname() {
		return this.loginname;
	}
}
