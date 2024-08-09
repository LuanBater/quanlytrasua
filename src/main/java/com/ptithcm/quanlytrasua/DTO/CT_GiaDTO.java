package com.ptithcm.quanlytrasua.DTO;

public class CT_GiaDTO {
    private int idctsp;
    private String mabg;
    private int giaban;
    private int tylegiam;
    public  CT_GiaDTO(){

    }

    public CT_GiaDTO(int idctsp, String mabg, int giaban, int tylegiam) {
        this.idctsp = idctsp;
        this.mabg = mabg;
        this.giaban = giaban;
        this.tylegiam = tylegiam;
    }

    public int getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(int idctsp) {
        this.idctsp = idctsp;
    }

    public String getMabg() {
        return mabg;
    }

    public void setMabg(String mabg) {
        this.mabg = mabg;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getTylegiam() {
        return tylegiam;
    }

    public void setTylegiam(int tylegiam) {
        this.tylegiam = tylegiam;
    }
}
