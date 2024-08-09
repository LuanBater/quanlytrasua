package com.ptithcm.quanlytrasua.DTO;

public class ThongKeThang {
    private int soluong;
    private String ngay;
    private int tong;
    public ThongKeThang(){}

    public ThongKeThang(int soluong, String ngay, int tong) {
        this.soluong = soluong;
        this.ngay = ngay;
        this.tong = tong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }
}
