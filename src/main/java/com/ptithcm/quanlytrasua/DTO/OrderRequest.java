package com.ptithcm.quanlytrasua.DTO;


import java.util.List;

public class OrderRequest {

    private String manv;
    private int thanhtoan;
    private List<CTDonHang> list_sanpham;
    public OrderRequest ()
    {

    }

    public OrderRequest(String manv, int thanhtoan, List<CTDonHang> list_sanpham) {
        this.manv = manv;
        this.thanhtoan = thanhtoan;
        this.list_sanpham = list_sanpham;
    }

    public String getManv() {
        return manv;
    }

    public void getManv(String manv) {
        this.manv = manv;
    }

//    public String getSdt() {
//        return sdt;
//    }
//
//    public void setSdt(String sdt) {
//        this.sdt = sdt;
//    }
//
//    public String getDiachi() {
//        return diachi;
//    }
//
//    public void setDiachi(String diachi) {
//        this.diachi = diachi;
//    }

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
