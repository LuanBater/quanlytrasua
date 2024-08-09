package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nguyenlieu")
public class NguyenLieu {
    @Id
    @Column(name = "MANL")
    private String maNL;

    @Column(name = "TENNL")
    private String tenNL;

    @Column(name = "SOLUONGTON")
    private int soLuongTon;

    @Column(name = "HINHANH")
    private String hinhAnh;
    public NguyenLieu()
    {

    }
    // getters and setters

    public NguyenLieu(String maNL, String tenNL, int soLuongTon, String hinhAnh) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.soLuongTon = soLuongTon;
        this.hinhAnh = hinhAnh;
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
