package com.ptithcm.quanlytrasua.DTO;

import java.util.List;

public class CTDonHang {
    private int idctdh;
    private int idctsp;
    private String tensp;
    private String masize;
    private int soluong;
    private int gia;
    private List<CTTopping> listCT_Topping;
    public CTDonHang(){}

    public CTDonHang(int idctdh, int idctsp, String tensp, String masize, int soluong, int gia, List<CTTopping> listCT_Topping) {
        this.idctdh = idctdh;
        this.idctsp = idctsp;
        this.tensp = tensp;
        this.masize = masize;
        this.soluong = soluong;
        this.gia = gia;
        this.listCT_Topping = listCT_Topping;
    }

    public List<CTTopping> getListCT_Topping() {
        return listCT_Topping;
    }

    public void setListCT_Topping(List<CTTopping> listCT_Topping) {
        this.listCT_Topping = listCT_Topping;
    }

    public int getIdctdh() {
        return idctdh;
    }

    public void setIdctdh(int idctdh) {
        this.idctdh = idctdh;
    }

    public int getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(int idctsp) {
        this.idctsp = idctsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMasize() {
        return masize;
    }

    public void setMasize(String masize) {
        this.masize = masize;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

}
