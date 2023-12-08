package com.example.mongodb.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sales {

    private ObjectId id;
    private Date saleDate;
    private List<Items> items;
    private String storeLocation;
    private Customer customer;
    private boolean couponUsed;
    private String purchaseMethod;

    public Sales(ObjectId id, Date saleDate, List<Items> items, String storeLocation, Customer customer, boolean couponUsed, String purchaseMethod) {
        this.id = id;
        this.saleDate = saleDate;
        this.items = items;
        this.storeLocation = storeLocation;
        this.customer = customer;
        this.couponUsed = couponUsed;
        this.purchaseMethod = purchaseMethod;
    }

    public Sales() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isCouponUsed() {
        return couponUsed;
    }

    public void setCouponUsed(boolean couponUsed) {
        this.couponUsed = couponUsed;
    }

    public String getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(String purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return isCouponUsed() == sales.isCouponUsed() && Objects.equals(getId(), sales.getId()) && Objects.equals(getSaleDate(), sales.getSaleDate()) && Objects.equals(getItems(), sales.getItems()) && Objects.equals(getStoreLocation(), sales.getStoreLocation()) && Objects.equals(getCustomer(), sales.getCustomer()) && Objects.equals(getPurchaseMethod(), sales.getPurchaseMethod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSaleDate(), getItems(), getStoreLocation(), getCustomer(), isCouponUsed(), getPurchaseMethod());
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", items=" + items +
                ", storeLocation='" + storeLocation + '\'' +
                ", customer=" + customer +
                ", couponUsed=" + couponUsed +
                ", purchaseMethod='" + purchaseMethod + '\'' +
                '}';
    }
}
