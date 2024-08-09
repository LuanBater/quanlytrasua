package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="phieunhap")
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPHIEUNHAP")
    private int maPhieuNhap;

    @Column(name = "NGAYNHAP")
    private String ngayNhap;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MADONDAT")
    private DonDatMua donDatMua;
    public PhieuNhap(){}
    // getters and setters

    public PhieuNhap(String ngayNhap, NhanVien nhanVien, DonDatMua donDatMua) {
        this.ngayNhap = ngayNhap;
        this.nhanVien = nhanVien;
        this.donDatMua = donDatMua;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public DonDatMua getDonDatMua() {
        return donDatMua;
    }

    public void setDonDatMua(DonDatMua donDatMua) {
        this.donDatMua = donDatMua;
    }
}