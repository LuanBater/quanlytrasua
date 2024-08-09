package com.ptithcm.quanlytrasua.DTO;

public class CTTopping {
    private int idctsp;
    private String tensp;
    private int soluong;
    private int gia;
    public CTTopping(){}


    public CTTopping(int idctsp, String tensp, int soluong, int gia) {
        this.idctsp = idctsp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
