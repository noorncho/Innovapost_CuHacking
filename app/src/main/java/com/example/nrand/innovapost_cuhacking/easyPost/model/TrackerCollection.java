package com.example.nrand.innovapost_cuhacking.easyPost.model;

import java.util.List;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class TrackerCollection extends EasyPostResource {
  List<Tracker> trackers;
  Boolean hasMore;

  public List<Tracker> getTrackers() {
    return trackers;
  }
  public void setTrackers(List<Tracker> trackers) {
    this.trackers = trackers;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}
