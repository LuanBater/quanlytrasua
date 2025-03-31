package com.ptithcm.quanlytrasua.DTO;

public class CT_GiaDTO {
    private String masp;
    private String mabg;
    private String tenbg;
    private int giasizeM;
    private int giasizeL;
    private String ngayapdung;
    private String ngaykt;
    public  CT_GiaDTO(){

    }

    public CT_GiaDTO(String masp, String mabg, String tenbg, int giasizeM, int giasizeL, String ngayapdung, String ngaykt) {
        this.masp = masp;
        this.mabg = mabg;
        this.tenbg = tenbg;
        this.giasizeM = giasizeM;
        this.giasizeL = giasizeL;
        this.ngayapdung = ngayapdung;
        this.ngaykt = ngaykt;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
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

    public int getGiasizeM() {
        return giasizeM;
    }

    public void setGiasizeM(int giasizeM) {
        this.giasizeM = giasizeM;
    }

    public int getGiasizeL() {
        return giasizeL;
    }

    public void setGiasizeL(int giasizeL) {
        this.giasizeL = giasizeL;
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
}
