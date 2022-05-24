package com.github.danilolopesabreu.domain;

public class Location {
	private long lat;
	private long log;

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLog() {
		return log;
	}

	public void setLog(long log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "Location [lat=" + lat + ", log=" + log + "]";
	}

}
