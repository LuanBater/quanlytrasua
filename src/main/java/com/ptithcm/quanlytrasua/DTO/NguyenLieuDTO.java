package com.ptithcm.quanlytrasua.DTO;

public class NguyenLieuDTO {
    String manl;
    String tennl;
    int soluongton;
    String hinhanh;
    public NguyenLieuDTO(){}

    public NguyenLieuDTO(String manl, String tennl, int soluongton, String hinhanh) {
        this.manl = manl;
        this.tennl = tennl;
        this.soluongton = soluongton;
        this.hinhanh = hinhanh;
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

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
