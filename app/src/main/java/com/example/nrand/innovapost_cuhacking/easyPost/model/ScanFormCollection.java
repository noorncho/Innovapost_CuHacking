package com.example.nrand.innovapost_cuhacking.easyPost.model;

import java.util.List;

import com.example.nrand.innovapost_cuhacking.easyPost.net.EasyPostResource;

public class ScanFormCollection extends EasyPostResource {
  List<ScanForm> scanForms;
  Boolean hasMore;

  public List<ScanForm> getScanForms() {
    return scanForms;
  }
  public void setScanForms(List<ScanForm> scanForms) {
    this.scanForms = scanForms;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}
