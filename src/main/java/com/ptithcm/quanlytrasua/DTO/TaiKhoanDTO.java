package com.ptithcm.quanlytrasua.DTO;



public class TaiKhoanDTO {
    private String username ;
    private String password;
    private boolean trangthai;
    private String maquyen;

    public TaiKhoanDTO(){}

    public TaiKhoanDTO(String username, String password, boolean trangthai, String maquyen) {
        this.username = username;
        this.password = password;
        this.trangthai = trangthai;
        this.maquyen = maquyen;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }
}
