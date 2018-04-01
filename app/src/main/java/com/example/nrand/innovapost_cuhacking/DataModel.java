package com.example.nrand.innovapost_cuhacking;

public class DataModel {

    private String provider;
    private String price;
    private String service;
    private String attributes;

    public DataModel(String provider, String price, String service, String attributes) {
        this.provider = provider;
        this.price = price;
        this.service = service;
        this.attributes = attributes;
    }

    public String getProvider() {
        return provider;
    }

    public String getPrice() {
        return price;
    }

    public String getService() {
        return service;
    }

    public String getAttributes() {
        return attributes;
    }
}
