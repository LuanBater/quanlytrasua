package com.ptithcm.quanlytrasua.DTO;

public class NhaCungCapDTO {
   private String mancc;
   private String tenncc;
    private String diachi;
   private String sdt;
   private String email;

    public NhaCungCapDTO(){}

    public NhaCungCapDTO(String mancc, String tenncc, String diachi, String sdt, String email) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
