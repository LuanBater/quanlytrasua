package com.ptithcm.quanlytrasua.DTO;



public class NLPhatSinhDTO {
    private String manv;
    private String tennv;
    private String manl;
    private String tennl;
    private String ngay;
    private int soluong;
    private String mota;
    public NLPhatSinhDTO(){}

    public NLPhatSinhDTO(String manv, String tennv, String manl, String tennl, String ngay, int soluong, String mota) {
        this.manv = manv;
        this.tennv = tennv;
        this.manl = manl;
        this.tennl = tennl;
        this.ngay = ngay;
        this.soluong = soluong;
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

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
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
