package com.ptithcm.quanlytrasua.DTO;

import com.ptithcm.quanlytrasua.model.DonHang;

import java.util.List;

public class DonHangDTO {
    private int madonhang;
    private String ngaytao;
    private int trangthai;
    private String manv;
    private String tennv;
    private String makh;
    private String tenkh;
    private String diachi;
    private int thanhtoan;
    private String sdt;
    private List<CTDonHang> ctdh;
    public DonHangDTO(){}

    public DonHangDTO(int madonhang, String ngaytao, int trangthai, String manv, String tennv, String makh, String tenkh, String diachi, int thanhtoan, String sdt, List<CTDonHang> ctdh) {
        this.madonhang = madonhang;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.manv = manv;
        this.tennv = tennv;
        this.makh = makh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.thanhtoan = thanhtoan;
        this.sdt = sdt;
        this.ctdh = ctdh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(int thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    public List<CTDonHang> getCtdh() {
        return ctdh;
    }

    public void setCtdh(List<CTDonHang> ctdh) {
        this.ctdh = ctdh;
    }

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
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

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }
}
