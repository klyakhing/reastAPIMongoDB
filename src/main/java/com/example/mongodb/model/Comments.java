package com.example.mongodb.model;

import java.util.Objects;

public class Comments {

    private String body;
    private String email;
    private String author;

    public Comments(String body, String email, String author) {
        this.body = body;
        this.email = email;
        this.author = author;
    }

    public Comments() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "body='" + body + '\'' +
                ", email='" + email + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(getBody(), comments.getBody()) && Objects.equals(getEmail(), comments.getEmail()) && Objects.equals(getAuthor(), comments.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBody(), getEmail(), getAuthor());
    }
}
