package com.ptithcm.quanlytrasua.DTO;

public class NguyenLieuNhapTrongThang {
    private String manl;
    private String tennl;
    private int maphieunhap;
    private String ngaynhap;
    private float soluongnhap;
    private int gianhap;
    private String donvi;
    private float thanhtien;
    private float tongsoluong;
    private float tongthanhtien;

    public NguyenLieuNhapTrongThang(){}
    public NguyenLieuNhapTrongThang(String manl, String tennl, int maphieunhap, String ngaynhap, float soluongnhap, int gianhap, String donvi, float thanhtien, float tongsoluong, float tongthanhtien) {
        this.manl = manl;
        this.tennl = tennl;
        this.maphieunhap = maphieunhap;
        this.ngaynhap = ngaynhap;
        this.soluongnhap = soluongnhap;
        this.gianhap = gianhap;
        this.donvi = donvi;
        this.thanhtien = thanhtien;
        this.tongsoluong = tongsoluong;
        this.tongthanhtien = tongthanhtien;
    }

    public String getManl() {
        return manl;
    }

    public void setManl(String manl) {
        this.manl = manl;
    }

    public String getTennl() {
        return tennl;
    }

    public void setTennl(String tennl) {
        this.tennl = tennl;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public float getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(float soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public float getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(float tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    public float getTongthanhtien() {
        return tongthanhtien;
    }

    public void setTongthanhtien(float tongthanhtien) {
        this.tongthanhtien = tongthanhtien;
    }
}
