package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="ct_topping")
public class CT_Topping {
    @Id
    private int idCTTP;
    @Column(name = "SOLUONG")
    private int soLuong;
    @ManyToOne
    @JoinColumn(name = "IDCTSP")
    private CT_SanPham idCTSP;

    @ManyToOne
    @JoinColumn(name = "IDCTDONHANG")
    private CT_DonHang idCTDH;
    public CT_Topping(){}
    // getters and setters

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public CT_SanPham getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(CT_SanPham idCTSP) {
        this.idCTSP = idCTSP;
    }

    public CT_DonHang getIdCTDH() {
        return idCTDH;
    }

    public void setIdCTDH(CT_DonHang idCTDH) {
        this.idCTDH = idCTDH;
    }
}
