package com.solvd.api.domain;

public class Pet {
    private Integer petId;
    private String category;
    private String name;
    private String photoUrls;
    private String tags;
    private String status;

    public Integer getPetId() {
        return petId;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public String getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
