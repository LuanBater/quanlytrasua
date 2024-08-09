package com.ptithcm.quanlytrasua.DTO;

public class NhanVienDTO {
    private String manv;
    private String tennv;
    private int phai;
    private String ngaysinh;
    private String diachi;
    private String hinhanh;
    private String email;
    private String sdt;
    private int nghilam;
    private String maquyen;
    public NhanVienDTO(){

    }

    public NhanVienDTO(String manv, String tennv, int phai, String ngaysinh, String diachi, String hinhanh, String email, String sdt, int nghilam, String maquyen) {
        this.manv = manv;
        this.tennv = tennv;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
        this.email = email;
        this.sdt = sdt;
        this.nghilam = nghilam;
        this.maquyen = maquyen;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
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
}
