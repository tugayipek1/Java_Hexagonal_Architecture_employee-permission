package com.phexum.wf.domain.building.entity;

import com.phexum.wf.domain.firm.entity.Firm;

public class Building {
  private Long id;
  private String name;
  private String address;
  private Firm firm;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Firm getFirm() {
    return firm;
  }

  public void setFirm(Firm firm) {
    this.firm = firm;
  }

}
