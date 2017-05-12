package com.kyrostechnologies.sample.messenger.model;

import java.io.Serializable;

public class Chat implements Serializable{
	private long id;
	private String date;
	private boolean read = false;
	private Friend friend;
	private String snippet;
	public Chat(long id, String date, boolean read, Friend friend, String snippet) {
		this.id = id;
		this.date = date;
		this.read = read;
		this.friend = friend;
		this.snippet = snippet;
	}

	public long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public boolean isRead() {
		return read;
	}

	public Friend getFriend() {
		return friend;
	}

	public String getSnippet() {
		return snippet;
	}
}