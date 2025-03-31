package com.ptithcm.quanlytrasua.DTO;

public class NguyenLieuDTO {
    String manl;
    String tennl;
    float soluongton;
    String hinhanh;
    float toithieu;
    String donvi;
    int trangthai;
    public NguyenLieuDTO(){}

    public NguyenLieuDTO(String manl, String tennl, float soluongton, String hinhanh, float toithieu, String donvi, int trangthai) {
        this.manl = manl;
        this.tennl = tennl;
        this.soluongton = soluongton;
        this.hinhanh = hinhanh;
        this.toithieu = toithieu;
        this.donvi = donvi;
        this.trangthai = trangthai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getManl() {
        return manl;
    }

    public void setManl(String manl) {
        this.manl = manl;
    }

    public String getTennl() {
        return tennl;
    }

    public void setTennl(String tennl) {
        this.tennl = tennl;
    }

    public float getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(float soluongton) {
        this.soluongton = soluongton;
    }

    public float getToithieu() {
        return toithieu;
    }

    public void setToithieu(float toithieu) {
        this.toithieu = toithieu;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
