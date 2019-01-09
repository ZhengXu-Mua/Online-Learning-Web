package com.xms.entity;

import java.sql.Timestamp;

public class Course {
	private Integer id;
	private String name;
	private Integer direction_id;
	private Integer content_id;
	private String description;
	private Double price;
	private String picture_url;
	private String video_url;
	private String uploader;
	private Timestamp uploadtime;
	private String updater;
	private Timestamp updatetime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDirection_id() {
		return direction_id;
	}
	public void setDirection_id(Integer directionId) {
		direction_id = directionId;
	}
	public Integer getContent_id() {
		return content_id;
	}
	public void setContent_id(Integer contentId) {
		content_id = contentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String pictureUrl) {
		picture_url = pictureUrl;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String videoUrl) {
		video_url = videoUrl;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public Timestamp getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
}
