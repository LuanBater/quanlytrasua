package com.ptithcm.quanlytrasua.model;

import jakarta.persistence.*;

@Entity
@Table(name="ct_sanpham")
public class CT_SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCTSP")
    private int idCTSP;

    @ManyToOne
    @JoinColumn(name = "MASP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "MASIZE")
    private SIZE size;
    public CT_SanPham()
    {

    }

    // getters and setters

    public CT_SanPham(SanPham sanPham, SIZE size) {
        this.sanPham = sanPham;
        this.size = size;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }
}
