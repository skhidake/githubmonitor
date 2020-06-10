package com.ssk.git.monitor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
	@JsonProperty("id")
	long id;
	
	@JsonProperty("type")
	String type;
	
	@JsonProperty("created_at")
	String createdAt;

	@JsonProperty("actor")
	Actor actor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	@Override
	public String toString() {
		return "Events [id=" + id + ", type=" + type + ", createdAt=" + createdAt + "]";
	}

}
