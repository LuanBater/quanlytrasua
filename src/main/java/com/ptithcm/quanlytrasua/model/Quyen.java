package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Quyen {
    @Id
    @Column(name = "MAQUYEN")
    private String maQuyen;

    @Column(name = "TENQUYEN")
    private String tenQuyen;
    public Quyen(){

    }
    public Quyen(String maQuyen, String tenQuyen) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
}