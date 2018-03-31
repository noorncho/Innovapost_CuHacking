package com.example.nrand.innovapost_cuhacking.easyPost.model;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

import java.util.List;

public class AddressCollection extends EasyPostResource {
  List<Batch> addresses;
  Boolean hasMore;

  public List<Batch> getAddresses() {
    return addresses;
  }
  public void setAddresses(List<Batch> addresses) {
    this.addresses = addresses;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}
