package com.ptithcm.quanlytrasua.DTO;

import java.util.List;

public class PhieuNhapDTO {
    private int madondat;
    private String manv;

    private List<NguyenLieuNhap> listNL;
    private int gianhap;
    public PhieuNhapDTO()
    {

    }

    public PhieuNhapDTO(int madondat, String manv, List<NguyenLieuNhap> listNL, int gianhap) {
        this.madondat = madondat;
        this.manv = manv;
        this.listNL = listNL;
        this.gianhap = gianhap;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getMadondat() {
        return madondat;
    }

    public void setMadondat(int madondat) {
        this.madondat = madondat;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public List<NguyenLieuNhap> getListNL() {
        return listNL;
    }

    public void setListNL(List<NguyenLieuNhap> listNL) {
        this.listNL = listNL;
    }
}
