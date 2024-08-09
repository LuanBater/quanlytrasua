package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="ct_banggia")
public class CT_BangGia {
    @Id
    private int idCTBG;

    @Column(name = "GIABAN")
    private int giaBan;
    @Column(name = "MOTA")
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "MABANGGIA")
    private BangGia bangGia;

    @ManyToOne
    @JoinColumn(name = "IDCTSP")
    private CT_SanPham ctSanPham;
public CT_BangGia(){}
    public CT_BangGia(int giaBan, String moTa, BangGia bangGia, CT_SanPham ctSanPham) {
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.bangGia = bangGia;
        this.ctSanPham = ctSanPham;
    }
    // getters and setters

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BangGia getBangGia() {
        return bangGia;
    }

    public void setBangGia(BangGia bangGia) {
        this.bangGia = bangGia;
    }

    public CT_SanPham getCtSanPham() {
        return ctSanPham;
    }

    public void setCtSanPham(CT_SanPham ctSanPham) {
        this.ctSanPham = ctSanPham;
    }
}