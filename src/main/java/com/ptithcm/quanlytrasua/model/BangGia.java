package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="banggia")
public class BangGia {
    @Id
    @Column(name = "MABANGGIA")
    private String maBangGia;

    @Column(name = "TENBANGGIA")
    private String tenBangGia;
    @Column(name = "TILEGIAM")
    private Float tiLeGiam;
    @Column(name = "NGAYAPDUNG")
    private String ngayApDung;

    @Column(name = "NGAYKT")
    private String ngayKT;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;
    public BangGia (){}
    // getters and setters

    public String getMaBangGia() {
        return maBangGia;
    }

    public Float getTiLeGiam() {
        return tiLeGiam;
    }

    public void setTiLeGiam(Float tiLeGiam) {
        this.tiLeGiam = tiLeGiam;
    }

    public void setMaBangGia(String maBangGia) {
        this.maBangGia = maBangGia;
    }

    public String getTenBangGia() {
        return tenBangGia;
    }

    public void setTenBangGia(String tenBangGia) {
        this.tenBangGia = tenBangGia;
    }

    public String getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(String ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
