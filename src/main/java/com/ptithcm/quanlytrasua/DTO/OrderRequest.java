package com.ptithcm.quanlytrasua.DTO;


import java.util.List;

public class OrderRequest {

    private String makh;
    private String sdt;
    private String diachi;
    private int thanhtoan;
    private List<CTDonHang> list_sanpham;
    public OrderRequest ()
    {

    }
    public OrderRequest(String makh, String sdt, String diachi, int thanhtoan, List<CTDonHang> list_sanpham) {
        this.makh = makh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.thanhtoan = thanhtoan;
        this.list_sanpham = list_sanpham;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
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

    public List<CTDonHang> getList_sanpham() {
        return list_sanpham;
    }

    public void setList_sanpham(List<CTDonHang> list_sanpham) {
        this.list_sanpham = list_sanpham;
    }
}
