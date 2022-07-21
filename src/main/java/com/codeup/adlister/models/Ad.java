package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String category;
    private String plant_name;
    private String location;
    private String price;
    private String description;
    private String photo;

    public Ad(long userId, String category, String plant_name, String location, String price, String description, String photo) {
        this.userId = userId;
        this.category = category;
        this.plant_name = plant_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Ad(long id, long userId, String category, String plant_name, String location, String price, String description, String photo) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.plant_name = plant_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }



//    public Ad(long id, long userId, String title, String description) {
//        this.id = id;
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//    }

//    public Ad(long userId, String title, String description) {
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//    }

    public Ad(long id, String user_id, String category, String plant_name, String location, String price, String description, String photo) {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

//    public String getTitle() {
//        return title;
//    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
