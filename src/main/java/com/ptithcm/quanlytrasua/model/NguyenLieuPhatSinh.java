package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="nguyenlieuphatsinh")
public class NguyenLieuPhatSinh {
    @Id
    private int idNLPS;
    @Column (name ="SOLUONG")
    private int soLuong;
    @Column (name ="MOTA")
    private int moTa;
    @ManyToOne
    @JoinColumn(name="MANV")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name="MANL")
    private NguyenLieu nguyenLieu;
    public NguyenLieuPhatSinh (){

    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMoTa() {
        return moTa;
    }

    public void setMoTa(int moTa) {
        this.moTa = moTa;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}
