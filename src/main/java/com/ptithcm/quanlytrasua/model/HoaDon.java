package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAHD")
    private int maHD;

    @Column(name = "NGAYXUAT")
    private String ngayXuat;
    @Column(name = "MST")
    private String mst;
    @Column(name = "TONGTIEN")
    private float tongTien;

    @OneToOne
    @JoinColumn(name = "MADONHANG")
    private DonHang donHang;
    public HoaDon(){}
    // getters and setters


    public HoaDon(String ngayXuat, String mst, float tongTien, DonHang donHang) {
        this.ngayXuat = ngayXuat;
        this.mst = mst;
        this.tongTien = tongTien;
        this.donHang = donHang;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getMst() {
        return mst;
    }

    public void setMst(String mst) {
        this.mst = mst;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}