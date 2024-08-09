package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="congthuc")
public class CongThuc {
    @Id
    private int idCongThuc;
    @Column(name = "SOLUONG")
    private int soluong;
    @Column(name = "MOTA")
    private String mota;
    @ManyToOne
    @JoinColumn(name = "IDCTSP")
    private CT_SanPham idctsp;
    @ManyToOne
    @JoinColumn(name = "MANL")
    private NguyenLieu manl;
    public CongThuc (){}
    public CongThuc(int soluong, String mota, CT_SanPham idctsp, NguyenLieu manl) {
        this.soluong = soluong;
        this.mota = mota;
        this.idctsp = idctsp;
        this.manl = manl;
    }

    public int getIdCongThuc() {
        return idCongThuc;
    }

    public void setIdCongThuc(int idCongThuc) {
        this.idCongThuc = idCongThuc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public CT_SanPham getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(CT_SanPham idctsp) {
        this.idctsp = idctsp;
    }

    public NguyenLieu getManl() {
        return manl;
    }

    public void setManl(NguyenLieu manl) {
        this.manl = manl;
    }
}
