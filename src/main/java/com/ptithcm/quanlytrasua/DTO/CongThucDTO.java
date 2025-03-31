package com.ptithcm.quanlytrasua.DTO;

public class  CongThucDTO {
    private String manl;
    private String tennl;
    private String donvi;
    private float soluong;
    private String mota;
    public CongThucDTO(){}

    public CongThucDTO(String manl, String tennl, String donvi, float soluong, String mota) {
        this.manl = manl;
        this.tennl = tennl;
        this.donvi = donvi;
        this.soluong = soluong;
        this.mota = mota;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
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

    public float getSoluong() {
        return soluong;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
