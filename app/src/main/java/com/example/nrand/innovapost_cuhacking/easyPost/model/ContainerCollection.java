package com.example.nrand.innovapost_cuhacking.easyPost.model;

import java.util.List;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class ContainerCollection extends EasyPostResource {
  List<Container> containers;
  Boolean hasMore;

  public List<Container> getContainers() {
    return containers;
  }
  public void setContainers(List<Container> containers) {
    this.containers = containers;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}
