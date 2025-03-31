package com.ptithcm.quanlytrasua.DTO;

public class ThongKePhieuNhap {
    private int maphieunhap;
    private String ngaynhap;
    private String manl;
    private String tennl;
    private int gianhap;
    private float soluong;
    private float thanhtien;
    public ThongKePhieuNhap()
    {

    }

    public ThongKePhieuNhap(int maphieunhap, String ngaynhap, String manl, String tennl, int gianhap, float soluong, float thanhtien) {
        this.maphieunhap = maphieunhap;
        this.ngaynhap = ngaynhap;
        this.manl = manl;
        this.tennl = tennl;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
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

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public float getSoluong() {
        return soluong;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
}
