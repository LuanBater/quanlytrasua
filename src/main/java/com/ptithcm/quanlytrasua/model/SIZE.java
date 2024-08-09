package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SIZE {
    @Id
    @Column(name = "MASIZE")
    private String maSize;

    @Column(name = "TENSIZE")
    private String tenSize;
    public SIZE (){}
    // getters and setters

    public SIZE(String maSize, String tenSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }
}