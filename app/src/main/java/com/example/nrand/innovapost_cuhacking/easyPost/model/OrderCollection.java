package com.example.nrand.innovapost_cuhacking.easyPost.model;

import java.util.List;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class OrderCollection extends EasyPostResource {
  List<Order> orders;
  Boolean hasMore;

  public List<Order> getOrders() {
    return orders;
  }
  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}
