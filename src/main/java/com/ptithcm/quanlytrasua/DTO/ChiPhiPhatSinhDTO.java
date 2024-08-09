package com.ptithcm.quanlytrasua.DTO;

public class ChiPhiPhatSinhDTO {
    private String macpps;
    private int chiphi;
    private String ngay;
    private String mota;
    private String manv;
    private String tennv;
    public ChiPhiPhatSinhDTO() {}

    public ChiPhiPhatSinhDTO(String macpps, int chiphi, String ngay, String mota, String manv, String tennv) {
        this.macpps = macpps;
        this.chiphi = chiphi;
        this.ngay = ngay;
        this.mota = mota;
        this.manv = manv;
        this.tennv = tennv;
    }

    public String getMacpps() {
        return macpps;
    }

    public void setMacpps(String macpps) {
        this.macpps = macpps;
    }

    public int getChiphi() {
        return chiphi;
    }

    public void setChiphi(int chiphi) {
        this.chiphi = chiphi;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
}
