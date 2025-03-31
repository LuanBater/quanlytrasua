package com.ptithcm.quanlytrasua.DTO;

public class ThongKeNguyenLieu {
    private String manl;
    private String tennl;
    private String donvi;
    private float tongsudung;
    private float soluongphatsinh;
    private float tongthuc;
    public ThongKeNguyenLieu(){};


    public ThongKeNguyenLieu(String manl, String tennl, String donvi, float tongsudung, float soluongphatsinh, float tongthuc) {
        this.manl = manl;
        this.tennl = tennl;
        this.donvi = donvi;
        this.tongsudung = tongsudung;
        this.soluongphatsinh = soluongphatsinh;
        this.tongthuc = tongthuc;
    }

    public float getSoluongphatsinh() {
        return soluongphatsinh;
    }

    public void setSoluongphatsinh(float soluongphatsinh) {
        this.soluongphatsinh = soluongphatsinh;
    }

    public float getTongthuc() {
        return tongthuc;
    }

    public void setTongthuc(float tongthuc) {
        this.tongthuc = tongthuc;
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

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public float getTongsudung() {
        return tongsudung;
    }

    public void setTongsudung(float tongsudung) {
        this.tongsudung = tongsudung;
    }
}
