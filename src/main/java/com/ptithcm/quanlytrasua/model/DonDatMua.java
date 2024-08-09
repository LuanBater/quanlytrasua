package com.ptithcm.quanlytrasua.model;


import jakarta.persistence.*;

@Entity
@Table(name="dondatmua")
public class DonDatMua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADONDAT")
    private int maDonDat;

    @Column(name = "NGAYDAT")
    private String ngayDat;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;
    public DonDatMua()
    {

    }
    // getters and setters

    public DonDatMua(String ngayDat, NhanVien nhanVien, NhaCungCap nhaCungCap) {
        this.ngayDat = ngayDat;
        this.nhanVien = nhanVien;
        this.nhaCungCap = nhaCungCap;
    }

    public int getMaDonDat() {
        return maDonDat;
    }

    public void setMaDonDat(int maDonDat) {
        this.maDonDat = maDonDat;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}