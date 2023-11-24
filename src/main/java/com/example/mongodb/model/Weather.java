package com.example.mongodb.model;

import java.util.Date;

public class Weather {


    private String name;

    private String permalink;

    private String crunchbase_url;

    private String homepage_url;

    private String blog_url;

    private String blog_feed_url;

    private String twitter_username;

    private String category_code;

    private int number_of_employees;

    private int founded_year;

    private int founded_month;

    private int founded_day;

    private int deadpooled_year;

    private String tag_list;

    private String alias_list;

    private String email_address;

    private String phone_number;

    private String description;

    private Date created_at;

    private String updated_at;

    private String overview;

    public Weather() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", permalink='" + permalink + '\'' +
                ", crunchbase_url='" + crunchbase_url + '\'' +
                ", homepage_url='" + homepage_url + '\'' +
                ", blog_url='" + blog_url + '\'' +
                ", blog_feed_url='" + blog_feed_url + '\'' +
                ", twitter_username='" + twitter_username + '\'' +
                ", category_code='" + category_code + '\'' +
                ", number_of_employees=" + number_of_employees +
                ", founded_year=" + founded_year +
                ", founded_month=" + founded_month +
                ", founded_day=" + founded_day +
                ", deadpooled_year=" + deadpooled_year +
                ", tag_list='" + tag_list + '\'' +
                ", alias_list='" + alias_list + '\'' +
                ", email_address='" + email_address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", updated_at='" + updated_at + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
