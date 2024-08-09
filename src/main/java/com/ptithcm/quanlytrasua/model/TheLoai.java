package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="theloai")
public class TheLoai {
    @Id
    @Column(name = "MALOAI")
    private String maLoai;

    @Column(name = "TENLOAI")
    private String tenLoai;
    public TheLoai(){}
    // getters and setters

    public TheLoai(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}