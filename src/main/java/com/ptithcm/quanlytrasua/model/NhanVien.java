package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="nhanvien")
public class NhanVien {
    @Id
    @Column(name = "MANV")
    private String maNV;

    @Column(name = "HOTEN")
    private String hoTen;

    @Column(name = "PHAI")
    private String phai;

    @Column(name = "NGAYSINH")
    private String ngaySinh;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "HINHANH")
    private String hinhAnh;
    @Column(name= "NGHILAM")
    private String nghiLam;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private TaiKhoan taiKhoan;
    public NhanVien(){}
    // getters and setters


    public NhanVien(String maNV, String hoTen, String phai, String ngaySinh, String diaChi, String sdt, String email, String hinhAnh, String nghiLam) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.hinhAnh = hinhAnh;
        this.nghiLam = nghiLam;
    }

    public String getNghiLam() {
        return nghiLam;
    }

    public void setNghiLam(String nghiLam) {
        this.nghiLam = nghiLam;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}