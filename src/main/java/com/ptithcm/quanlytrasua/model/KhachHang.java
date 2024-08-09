package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="khachhang")
public class KhachHang {
    @Id
    @Column(name = "MAKH")
    private String maKH;

    @Column(name = "HOTEN")
    private String hoTen;

    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "EMAIL")
    private String email;

//    @Column(name = "USERNAME")
//    private String username;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private TaiKhoan taiKhoan;
    public KhachHang(){}
    // getters and setters


    public KhachHang(String maKH, String hoTen, String diaChi, String sdt, String email) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
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

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
