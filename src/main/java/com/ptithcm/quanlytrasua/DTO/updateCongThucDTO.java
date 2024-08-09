package com.ptithcm.quanlytrasua.DTO;

public class updateCongThucDTO
{
    private String masp;
    private String manl;
    private int soluong;
    private String mota;
    public updateCongThucDTO(){}

    public updateCongThucDTO(String masp, String manl, int soluong, String mota) {
        this.masp = masp;
        this.manl = manl;
        this.soluong = soluong;
        this.mota = mota;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getManl() {
        return manl;
    }

    public void setManl(String manl) {
        this.manl = manl;
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
}
