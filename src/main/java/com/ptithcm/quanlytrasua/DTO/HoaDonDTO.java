package com.ptithcm.quanlytrasua.DTO;

import java.util.List;

public class HoaDonDTO {
    private int mahoadon;
    private String ngayxuat;
    private int tonggia;
    private String mst;
    private int madonhang;
    private String manv;
    private String tennv;
    private String makh;
    private String tenkh;
    private List<CTDonHang> ctdh;
    public HoaDonDTO(){}

    public int getMahoadon() {
        return mahoadon;
    }

    public HoaDonDTO(int mahoadon, String ngayxuat, int tonggia, String mst, int madonhang, String manv, String tennv, String makh, String tenkh, List<CTDonHang> ctdh) {
        this.mahoadon = mahoadon;
        this.ngayxuat = ngayxuat;
        this.tonggia = tonggia;
        this.mst = mst;
        this.madonhang = madonhang;
        this.manv = manv;
        this.tennv = tennv;
        this.makh = makh;
        this.tenkh = tenkh;
        this.ctdh = ctdh;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(String ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public int getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }

    public String getMst() {
        return mst;
    }

    public void setMst(String mst) {
        this.mst = mst;
    }

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public List<CTDonHang> getCtdh() {
        return ctdh;
    }

    public void setCtdh(List<CTDonHang> ctdh) {
        this.ctdh = ctdh;
    }
}
