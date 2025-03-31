package com.ptithcm.quanlytrasua.DTO;

public class ChiTietNhapNL {
    private int maphieunhap;
    private String manl;
    private String tennl;
    private String donvi;
    private float soluong;
    private float tonkhotruoc;
    private float tonkhosau;
    private String ngaynhap;
    private int gianhap;
    public ChiTietNhapNL(){};

    public ChiTietNhapNL(int maphieunhap, String manl, String tennl, String donvi, float soluong, float tonkhotruoc, float tonkhosau, String ngaynhap, int gianhap) {
        this.maphieunhap = maphieunhap;
        this.manl = manl;
        this.tennl = tennl;
        this.donvi = donvi;
        this.soluong = soluong;
        this.tonkhotruoc = tonkhotruoc;
        this.tonkhosau = tonkhosau;
        this.ngaynhap = ngaynhap;
        this.gianhap = gianhap;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
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

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public float getSoluong() {
        return soluong;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }


    public float getTonkhotruoc() {
        return tonkhotruoc;
    }

    public void setTonkhotruoc(float tonkhotruoc) {
        this.tonkhotruoc = tonkhotruoc;
    }

    public float getTonkhosau() {
        return tonkhosau;
    }

    public void setTonkhosau(float tonkhosau) {
        this.tonkhosau = tonkhosau;
    }
}
