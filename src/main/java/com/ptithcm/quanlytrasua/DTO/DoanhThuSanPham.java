package com.ptithcm.quanlytrasua.DTO;

public class DoanhThuSanPham {
    private int idctsp;
    private String masp;
    private String tensp;
    private String masize;
    private int giaban;
    private float soluongban;
    private float doanhthu;
    public DoanhThuSanPham(){};


    public DoanhThuSanPham(int idctsp, String masp, String tensp, String masize, int giaban, float soluongban, float doanhthu) {
        this.idctsp = idctsp;
        this.masp = masp;
        this.tensp = tensp;
        this.masize = masize;
        this.giaban = giaban;
        this.soluongban = soluongban;
        this.doanhthu = doanhthu;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public String getMasize() {
        return masize;
    }

    public void setMasize(String masize) {
        this.masize = masize;
    }

    public int getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(int idctsp) {
        this.idctsp = idctsp;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getSoluongban() {
        return soluongban;
    }

    public void setSoluongban(float soluongban) {
        this.soluongban = soluongban;
    }

    public float getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }
}
