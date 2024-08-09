package com.ptithcm.quanlytrasua.DTO;

public class ToppingBan {
    private String masp;
    private int idctsp;
    private String tensp;
    private String hinhanh;
    private int gia;
    private int khadung;
    public ToppingBan(){}

    public ToppingBan(String masp, int idctsp, String tensp, String hinhanh, int gia, int khadung) {
        this.masp = masp;
        this.idctsp = idctsp;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.khadung = khadung;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(int idctsp) {
        this.idctsp = idctsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getKhadung() {
        return khadung;
    }

    public void setKhadung(int khadung) {
        this.khadung = khadung;
    }
}
