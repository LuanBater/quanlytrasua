package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="sanpham")
public class SanPham {
    @Id
    @Column(name = "MASP")
    private String maSP;

    @Column(name = "TENSP")
    private String tenSP;

    @Column(name = "HINHANH")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "MALOAI")
    private TheLoai theLoai;
    public SanPham(){}
    // getters and setters

    public SanPham(String maSP, String tenSP, String hinhAnh, TheLoai theLoai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hinhAnh = hinhAnh;
        this.theLoai = theLoai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }
}