package com.ptithcm.quanlytrasua.DTO;

import java.util.List;

public class DonDatMuaDTO {
    private String manv;
    private String mancc;
    private List<NguyenLieuNhap> listNL;
    public DonDatMuaDTO(){}

    public DonDatMuaDTO(String manv, String mancc,List<NguyenLieuNhap> listNL) {
        this.manv = manv;
        this.mancc = mancc;
        this.listNL = listNL;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }


    public List<NguyenLieuNhap> getListNL() {
        return listNL;
    }

    public void setListNL(List<NguyenLieuNhap> listNL) {
        this.listNL = listNL;
    }
}
