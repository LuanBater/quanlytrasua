package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="ct_phieunhap")
public class CT_PhieuNhap {
    @Id
    private int idCTPN;
    @Column(name = "SOLUONG")
    private int soLuong;
    @Column(name = "GIANHAP")
    private int GIANHAP;
    @ManyToOne
    @JoinColumn(name = "MAPHIEUNHAP")
    private PhieuNhap phieuNhap;

    @ManyToOne
    @JoinColumn(name = "MANL")
    private NguyenLieu nguyenLieu;
    public CT_PhieuNhap(){}
    // getters and setters

    public CT_PhieuNhap(int soLuong, int GIANHAP, PhieuNhap phieuNhap, NguyenLieu nguyenLieu) {
        this.soLuong = soLuong;
        this.GIANHAP = GIANHAP;
        this.phieuNhap = phieuNhap;
        this.nguyenLieu = nguyenLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGIANHAP() {
        return GIANHAP;
    }

    public void setGIANHAP(int GIANHAP) {
        this.GIANHAP = GIANHAP;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}