package com.instacart.ecommerce.entity;

public class Address {
    private Long id;
    private User user;
    private String fullName;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private AddressType addressType;
    private Boolean isDefault = false;

    public enum AddressType {
        HOME,
        WORK,
        OTHER
    }
}
