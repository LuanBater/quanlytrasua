package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="ct_dondatmua")
public class CT_DonDatMua {
    @Id
    private int idCTDDM;
    @Column(name = "SOLUONG")
    private int soLuong;
    @ManyToOne
    @JoinColumn(name = "MADONDAT")
    private DonDatMua donDatMua;

    @ManyToOne
    @JoinColumn(name = "MANL")
    private NguyenLieu nguyenLieu;
    public CT_DonDatMua(){}
    // getters and setters

    public CT_DonDatMua(int soLuong, DonDatMua donDatMua, NguyenLieu nguyenLieu) {
        this.soLuong = soLuong;
        this.donDatMua = donDatMua;
        this.nguyenLieu = nguyenLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DonDatMua getDonDatMua() {
        return donDatMua;
    }

    public void setDonDatMua(DonDatMua donDatMua) {
        this.donDatMua = donDatMua;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}