package com.example.nrand.innovapost_cuhacking.easyPost.model;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class ApiKey extends EasyPostResource {
    String mode;
    String key;

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
}

