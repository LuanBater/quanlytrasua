package com.ptithcm.quanlytrasua.DTO;

public class BangGiaDTO {
    private String mabg;
    private String tenbg;
    private int tylegiam;
    private String ngayapdung;
    private String ngaykt;
    private String manv;
    private String loaigia;
    public BangGiaDTO(){}

    public BangGiaDTO(String mabg, String tenbg, int tylegiam, String ngayapdung, String ngaykt, String manv, String loaigia) {
        this.mabg = mabg;
        this.tenbg = tenbg;
        this.tylegiam = tylegiam;
        this.ngayapdung = ngayapdung;
        this.ngaykt = ngaykt;
        this.manv = manv;
        this.loaigia = loaigia;
    }

    public String getLoaigia() {
        return loaigia;
    }

    public void setLoaigia(String loaigia) {
        this.loaigia = loaigia;
    }

    public String getMabg() {
        return mabg;
    }

    public void setMabg(String mabg) {
        this.mabg = mabg;
    }

    public String getTenbg() {
        return tenbg;
    }

    public void setTenbg(String tenbg) {
        this.tenbg = tenbg;
    }

    public int getTylegiam() {
        return tylegiam;
    }

    public void setTylegiam(int tylegiam) {
        this.tylegiam = tylegiam;
    }

    public String getNgayapdung() {
        return ngayapdung;
    }

    public void setNgayapdung(String ngayapdung) {
        this.ngayapdung = ngayapdung;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
}
