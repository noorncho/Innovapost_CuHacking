package com.example.nrand.innovapost_cuhacking.easyPost.model;

import java.util.List;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class PickupCollection extends EasyPostResource {
    List<Pickup> pickups;
    Boolean hasMore;

    public List<Pickup> getPickups() {
        return pickups;
    }
    public void setPickups(List<Pickup> pickups) {
        this.pickups = pickups;
    }
    public Boolean getHasMore() {
        return hasMore;
    }
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
