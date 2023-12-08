package com.example.mongodb.model;

import java.util.Objects;

public class Customer {

    private String gender;
    private Integer age;
    private String email;
    private Integer satisfaction;

    public Customer(String gender, Integer age, String email, Integer satisfaction) {
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.satisfaction = satisfaction;
    }

    public Customer() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getGender(), customer.getGender()) && Objects.equals(getAge(), customer.getAge()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getSatisfaction(), customer.getSatisfaction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGender(), getAge(), getEmail(), getSatisfaction());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", satisfaction=" + satisfaction +
                '}';
    }
}
