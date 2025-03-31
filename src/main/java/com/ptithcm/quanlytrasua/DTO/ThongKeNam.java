package com.ptithcm.quanlytrasua.DTO;

public class ThongKeNam {
    private int nam;
    private float tongq1;
    private float tongq2;
    private float tongq3;
    private float tongq4;
    public ThongKeNam(){}


    public ThongKeNam(int nam, float tongq1, float tongq2, float tongq3, float tongq4) {
        this.nam = nam;
        this.tongq1 = tongq1;
        this.tongq2 = tongq2;
        this.tongq3 = tongq3;
        this.tongq4 = tongq4;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public float getTongq4() {
        return tongq4;
    }

    public void setTongq4(float tongq4) {
        this.tongq4 = tongq4;
    }

    public float getTongq1() {
        return tongq1;
    }

    public void setTongq1(float tongq1) {
        this.tongq1 = tongq1;
    }

    public float getTongq2() {
        return tongq2;
    }

    public void setTongq2(float tongq2) {
        this.tongq2 = tongq2;
    }

    public float getTongq3() {
        return tongq3;
    }

    public void setTongq3(float tongq3) {
        this.tongq3 = tongq3;
    }

    @Override
    public String toString() {
        return "ThongKeNam{" +
                "nam=" + nam +
                ", tongq1=" + tongq1 +
                ", tongq2=" + tongq2 +
                ", tongq3=" + tongq3 +
                '}';
    }
}
