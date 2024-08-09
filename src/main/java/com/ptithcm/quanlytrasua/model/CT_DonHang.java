package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="ct_donhang")
public class CT_DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCTDONHANG")
    private int idCTDH;
    @Column(name = "SOLUONG")
    private int soLuong;
    @ManyToOne
    @JoinColumn(name = "MADONHANG")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "IDCTSP")
    private CT_SanPham ctSanPham;
    public CT_DonHang(){}
    // getters and setters

    public CT_DonHang(int soLuong, DonHang donHang, CT_SanPham ctSanPham) {
        this.soLuong = soLuong;
        this.donHang = donHang;
        this.ctSanPham = ctSanPham;
    }

    public int getIdCTDH() {
        return idCTDH;
    }

    public void setIdCTDH(int idCTDH) {
        this.idCTDH = idCTDH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public CT_SanPham getCtSanPham() {
        return ctSanPham;
    }

    public void setCtSanPham(CT_SanPham ctSanPham) {
        this.ctSanPham = ctSanPham;
    }
}
