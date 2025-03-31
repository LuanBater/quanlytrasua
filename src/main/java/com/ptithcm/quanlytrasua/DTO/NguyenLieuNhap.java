package com.ptithcm.quanlytrasua.DTO;

public class NguyenLieuNhap {

    private String manl;
    private  String tennl;
    private Float soluong;
    private String donvi;
    private int gianhap;


    public  NguyenLieuNhap(){

    }

    public NguyenLieuNhap(String manl, String tennl, Float soluong, String donvi,int gianhap) {
        this.manl = manl;
        this.tennl = tennl;
        this.soluong = soluong;
        this.donvi = donvi;
        this.gianhap = gianhap;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
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

    public Float getSoluong() {
        return soluong;
    }

    public void setSoluong(Float soluong) {
        this.soluong = soluong;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
}
