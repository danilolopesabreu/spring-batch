package com.github.danilolopesabreu.domain;

public class Address {
	private String name;
	private Location location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", location=" + location + "]";
	}

	

}
