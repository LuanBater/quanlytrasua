package com.ptithcm.quanlytrasua.DTO;

public class PhieuNhapShow {
    private int mapn;
    private int madondat;
    private String ngaynhap;
    private String manv;
    private String tennv;
    private String mancc;
    private String tenncc;
    public PhieuNhapShow(){}

    public PhieuNhapShow(int mapn, int madondat, String ngaynhap, String manv, String tennv, String mancc, String tenncc) {
        this.mapn = mapn;
        this.madondat = madondat;
        this.ngaynhap = ngaynhap;
        this.manv = manv;
        this.tennv = tennv;
        this.mancc = mancc;
        this.tenncc = tenncc;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public int getMapn() {
        return mapn;
    }

    public void setMapn(int mapn) {
        this.mapn = mapn;
    }

    public int getMadondat() {
        return madondat;
    }

    public void setMadondat(int madondat) {
        this.madondat = madondat;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }
}
