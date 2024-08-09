package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="donhang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADONHANG")
    private int maDonHang;

    @Column(name = "NGAYTAO")
    private String ngayTao;

    @Column(name = "TRANGTHAI")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MAKH")
    private KhachHang khachHang;
    public DonHang()
    {

    }
    public DonHang( String ngayTao, String trangThai, NhanVien nhanVien, KhachHang khachHang) {

        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
    }
    // getters and setters

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}