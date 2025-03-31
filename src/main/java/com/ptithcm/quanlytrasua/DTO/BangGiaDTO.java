package com.ptithcm.quanlytrasua.DTO;

public class  BangGiaDTO {
    private String mabg;
    private String tenbg;

    private String manv;

    public BangGiaDTO(){}

    public BangGiaDTO(String mabg, String tenbg, String manv) {
        this.mabg = mabg;
        this.tenbg = tenbg;
        this.manv = manv;
    }


    public String getMabg() {
        return mabg;
    }

    public void setMabg(String mabg) {
        this.mabg = mabg;
    }

    public String getTenbg() {
        return tenbg;
    }

    public void setTenbg(String tenbg) {
        this.tenbg = tenbg;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
}
