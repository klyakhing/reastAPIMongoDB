package com.example.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="inspections")
public class Inspection {


    private String id;

    private long certificate_number;

    private String business_name;

    private Date date;

    private String result;

    private String sector;

    private Address address;

    public Inspection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(long certificate_number) {
        this.certificate_number = certificate_number;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "id='" + id + '\'' +
                ", certificate_number=" + certificate_number +
                ", business_name='" + business_name + '\'' +
                ", date=" + date +
                ", result='" + result + '\'' +
                ", sector='" + sector + '\'' +
                ", address=" + address +
                '}';
    }
}
