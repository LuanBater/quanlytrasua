package com.ptithcm.quanlytrasua.DTO;

import java.util.List;

public class HoanThanhDonHang {
    private int madonhang;
    private List<CTDonHang> list_sanpham;
    public HoanThanhDonHang(){}
    public HoanThanhDonHang(int madonhang, List<CTDonHang> list_sanpham) {
        this.madonhang = madonhang;
        this.list_sanpham = list_sanpham;
    }

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public List<CTDonHang> getList_sanpham() {
        return list_sanpham;
    }

    public void setList_sanpham(List<CTDonHang> list_sanpham) {
        this.list_sanpham = list_sanpham;
    }
}
