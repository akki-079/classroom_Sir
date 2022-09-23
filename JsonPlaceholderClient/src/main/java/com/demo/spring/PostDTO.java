package com.demo.spring;

public class PostDTO {
	private Integer userID;
	private Integer id;
	private String title;
	private String body;
	public PostDTO() {

	}
	public PostDTO(Integer userID, Integer id, String title, String body) {
		super();
		this.userID = userID;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	

}
