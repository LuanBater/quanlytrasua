package com.ptithcm.quanlytrasua.DTO;

public class CongThucDTO {
    private String manl;
    private String tennl;
    private int soluong;
    private String mota;
    public CongThucDTO(){}

    public CongThucDTO(String manl, String tennl, int soluong, String mota) {
        this.manl = manl;
        this.tennl = tennl;
        this.soluong = soluong;
        this.mota = mota;
    }

    public String getTennl() {
        return tennl;
    }

    public void setTennl(String tennl) {
        this.tennl = tennl;
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
