package com.ptithcm.quanlytrasua.DTO;

public class ThongKeThang {
    private int soluong;
    private String ngay;
    private float tong;
    public ThongKeThang(){}

    public ThongKeThang(int soluong, String ngay, float tong) {
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

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }
}
