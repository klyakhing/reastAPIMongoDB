package com.example.mongodb.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Posts {

    private ObjectId id;
    private String body;
    private String permalink;
    private String author;
    private String title;
    private List<String> tags;
    private List<Comments> comments;
    private Date date;

    public Posts(ObjectId id, String body, String permalink, String author, String title, List<String> tags, List<Comments> comments, Date date) {
        this.id = id;
        this.body = body;
        this.permalink = permalink;
        this.author = author;
        this.title = title;
        this.tags = tags;
        this.comments = comments;
        this.date = date;
    }

    public Posts() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return Objects.equals(getId(), posts.getId()) && Objects.equals(getBody(), posts.getBody()) && Objects.equals(getPermalink(), posts.getPermalink()) && Objects.equals(getAuthor(), posts.getAuthor()) && Objects.equals(getTitle(), posts.getTitle()) && Objects.equals(getTags(), posts.getTags()) && Objects.equals(getComments(), posts.getComments()) && Objects.equals(getDate(), posts.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBody(), getPermalink(), getAuthor(), getTitle(), getTags(), getComments(), getDate());
    }
}
