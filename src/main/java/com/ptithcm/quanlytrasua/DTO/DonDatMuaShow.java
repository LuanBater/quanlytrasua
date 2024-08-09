package com.ptithcm.quanlytrasua.DTO;

public class DonDatMuaShow {
    private int madondat;
    private String mancc;
    private String tenncc;
    private String ngaydat;
    private String manv;
    private String tennv;
    private int danhap;
    public DonDatMuaShow(){

    }

    public DonDatMuaShow(int madondat, String mancc, String tenncc, String ngaydat, String manv, String tennv, int danhap) {
        this.madondat = madondat;
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.ngaydat = ngaydat;
        this.manv = manv;
        this.tennv = tennv;
        this.danhap = danhap;
    }

    public int getDanhap() {
        return danhap;
    }

    public void setDanhap(int danhap) {
        this.danhap = danhap;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public int getMadondat() {
        return madondat;
    }

    public void setMadondat(int madondat) {
        this.madondat = madondat;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
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
