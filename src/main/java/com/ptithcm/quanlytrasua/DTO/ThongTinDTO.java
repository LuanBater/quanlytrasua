package com.ptithcm.quanlytrasua.DTO;

public class ThongTinDTO {
    private String ma;
    private String ten;
    private int phai;
    private String ngaysinh;
    private String diachi;
    private String hinhanh;
    private String email;
    private String sdt;
    private int nghilam;
    private String maquyen;
    public ThongTinDTO(){}

    public ThongTinDTO(String ma, String ten, int phai, String ngaysinh, String diachi, String hinhanh, String email, String sdt, int nghilam, String maquyen) {
        this.ma = ma;
        this.ten = ten;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
        this.email = email;
        this.sdt = sdt;
        this.nghilam = nghilam;
        this.maquyen = maquyen;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getPhai() {
        return phai;
    }

    public void setPhai(int phai) {
        this.phai = phai;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getNghilam() {
        return nghilam;
    }

    public void setNghilam(int nghilam) {
        this.nghilam = nghilam;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }
}
