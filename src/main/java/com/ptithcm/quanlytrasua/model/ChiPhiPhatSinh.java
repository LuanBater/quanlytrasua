package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="chiphiphatsinh")
public class ChiPhiPhatSinh {
    @Id
    @Column(name = "MACPPS")
    private int maCPPS;

    @Column(name = "CHIPHI")
    private float chiPhi;

    @Column(name = "NGAY")
    private String ngayChi;

    @Column(name = "MOTA")
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;
    public ChiPhiPhatSinh(){}
    // getters and setters

    public ChiPhiPhatSinh(int maCPPS, float chiPhi, String ngayChi, String moTa, NhanVien nhanVien) {
        this.maCPPS = maCPPS;
        this.chiPhi = chiPhi;
        this.ngayChi = ngayChi;
        this.moTa = moTa;
        this.nhanVien = nhanVien;
    }

    public int getMaCPPS() {
        return maCPPS;
    }

    public void setMaCPPS(int maCPPS) {
        this.maCPPS = maCPPS;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
