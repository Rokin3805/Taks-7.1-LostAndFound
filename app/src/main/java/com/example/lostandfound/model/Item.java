package com.example.lostandfound.model;

public class Item {
    private String postType;
    private String poster;
    private String phoneNo;
    private String description;
    private String location;
    private String date;

    public Item(String postType, String poster, String phoneNo, String description, String location, String date) {
        this.postType = postType;
        this.poster = poster;
        this.phoneNo = phoneNo;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public Item() {
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
