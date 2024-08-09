package com.ptithcm.quanlytrasua.DTO;

public class UpdateKhuyenMaiDTO {
    private String mabgcu;
    private String mabgmoi;
    private int giaM;
    private int giaL;
    private int idctspM;
    private int idctspL;
    public UpdateKhuyenMaiDTO(){}

    public UpdateKhuyenMaiDTO(String mabgcu, String mabgmoi, int giaM, int giaL, int idctspM, int idctspL) {
        this.mabgcu = mabgcu;
        this.mabgmoi = mabgmoi;
        this.giaM = giaM;
        this.giaL = giaL;
        this.idctspM = idctspM;
        this.idctspL = idctspL;
    }

    public String getMabgcu() {
        return mabgcu;
    }

    public void setMabgcu(String mabgcu) {
        this.mabgcu = mabgcu;
    }

    public String getMabgmoi() {
        return mabgmoi;
    }

    public void setMabgmoi(String mabgmoi) {
        this.mabgmoi = mabgmoi;
    }

    public int getGiaM() {
        return giaM;
    }

    public void setGiaM(int giaM) {
        this.giaM = giaM;
    }

    public int getGiaL() {
        return giaL;
    }

    public void setGiaL(int giaL) {
        this.giaL = giaL;
    }

    public int getIdctspM() {
        return idctspM;
    }

    public void setIdctspM(int idctspM) {
        this.idctspM = idctspM;
    }

    public int getIdctspL() {
        return idctspL;
    }

    public void setIdctspL(int idctspL) {
        this.idctspL = idctspL;
    }
}
