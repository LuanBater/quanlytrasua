package com.ptithcm.quanlytrasua.DTO;

public class ThongTinSanPhamDTO {
    private String masp;
    private String tensp;
    private String maloai;
    private String hinhanh;
    private int idctspM;
    private int giaM;
    private int idctspL;
    private int giaL;

    private int khadung;
    private String mabg;
    public ThongTinSanPhamDTO(){}

    public ThongTinSanPhamDTO(String masp, String tensp, String maloai, String hinhanh, int idctspM, int giaM, int idctspL, int giaL,  int khadung, String mabg) {
        this.masp = masp;
        this.tensp = tensp;
        this.maloai = maloai;
        this.hinhanh = hinhanh;
        this.idctspM = idctspM;
        this.giaM = giaM;
        this.idctspL = idctspL;
        this.giaL = giaL;

        this.khadung = khadung;
        this.mabg = mabg;
    }

    public int getIdctspM() {
        return idctspM;
    }

    public void setIdctspM(int idctspM) {
        this.idctspM = idctspM;
    }

    public int getIdctspL() {
        return idctspL;
    }

    public void setIdctspL(int idctspL) {
        this.idctspL = idctspL;
    }



    public int getKhadung() {
        return khadung;
    }

    public void setKhadung(int khadung) {
        this.khadung = khadung;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getGiaM() {
        return giaM;
    }

    public void setGiaM(int giaM) {
        this.giaM = giaM;
    }

    public int getGiaL() {
        return giaL;
    }

    public void setGiaL(int giaL) {
        this.giaL = giaL;
    }

    public String getMabg() {
        return mabg;
    }

    public void setMabg(String mabg) {
        this.mabg = mabg;
    }
}
