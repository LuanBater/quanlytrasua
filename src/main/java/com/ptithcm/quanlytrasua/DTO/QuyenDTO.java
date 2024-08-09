package com.ptithcm.quanlytrasua.DTO;

public class QuyenDTO {
    private String maquyen;
    private String tenquyen;

    public QuyenDTO(String maquyen, String tenquyen) {
        this.maquyen = maquyen;
        this.tenquyen = tenquyen;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }
}
