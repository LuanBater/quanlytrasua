package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nhacungcap")
public class NhaCungCap {
    @Id
    @Column(name = "MANCC")
    private String maNCC;

    @Column(name = "TENNCC")
    private String tenNCC;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DIACHI")
    private String diaChi;
    public NhaCungCap(){}
    // getters and setters

    public NhaCungCap(String maNCC, String tenNCC, String sdt, String email, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}