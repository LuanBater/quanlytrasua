package com.ptithcm.quanlytrasua.DTO;

public class NguyenLieuNhap {
    private String manl;
    private  String tennl;
    private int soluong;
    private int gianhap;
    public  NguyenLieuNhap(){

    }

    public NguyenLieuNhap(String manl, String tennl, int soluong, int gianhap) {
        this.manl = manl;
        this.tennl = tennl;
        this.soluong = soluong;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
