package com.ptithcm.quanlytrasua.DTO;

public class SanPhamKhaDung {
    private int idctsp;
    private String tensp;
    private String masize;
    private float soluongkhadung;
    public SanPhamKhaDung(){};

    public SanPhamKhaDung(int idctsp, String tensp, String masize, float soluongkhadung) {
        this.idctsp = idctsp;
        this.tensp = tensp;
        this.masize = masize;
        this.soluongkhadung = soluongkhadung;
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

    public String getMasize() {
        return masize;
    }

    public void setMasize(String masize) {
        this.masize = masize;
    }

    public float getSoluongkhadung() {
        return soluongkhadung;
    }

    public void setSoluongkhadung(float soluongkhadung) {
        this.soluongkhadung = soluongkhadung;
    }
}
