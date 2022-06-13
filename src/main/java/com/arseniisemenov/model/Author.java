package com.arseniisemenov.model;

public class Author {
    private int id;
    private String name;
    private String country;
    private String biography;

    public Author(int id, String name, String country, String biography) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.biography = biography;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getBiography() {
        return this.biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
}
