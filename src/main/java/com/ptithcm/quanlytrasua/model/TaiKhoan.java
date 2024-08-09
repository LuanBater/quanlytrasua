package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="taikhoan")
public class TaiKhoan {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TRANGTHAI")
    private boolean trangThai;

    @OneToOne(mappedBy = "taiKhoan")
    private NhanVien nhanVien;

    @OneToOne(mappedBy = "taiKhoan")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MAQUYEN")
    private Quyen quyen;

    public TaiKhoan()
    {

    }
    // getters and setters

    public TaiKhoan(String username, String password, boolean trangThai, Quyen quyen) {
        this.username = username;
        this.password = password;
        this.trangThai = trangThai;
        this.quyen = quyen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }
}