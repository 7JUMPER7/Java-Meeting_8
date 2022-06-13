package com.arseniisemenov.model;

public class Verse {
    private int id;
    private String text;
    private int authorId;
    private int categoryId;

    public Verse(int id, String text, int authorId, int categoryId) {
        this.id = id;
        this.text = text;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getAuthorId() {
        return this.authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
