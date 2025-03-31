package com.ptithcm.quanlytrasua.DTO;

public class ThongKeQuy {
    private String quy;
    private float tongthang1;
    private float tongthang2;
    private float tongthang3;
    private float tongquy;
    public ThongKeQuy(){}

    public ThongKeQuy(String quy, float tongthang1, float tongthang2, float tongthang3, float tongquy) {
        this.quy = quy;
        this.tongthang1 = tongthang1;
        this.tongthang2 = tongthang2;
        this.tongthang3 = tongthang3;
        this.tongquy = tongquy;
    }

    public String getQuy() {
        return quy;
    }

    public float getTongthang1() {
        return tongthang1;
    }

    public float getTongthang2() {
        return tongthang2;
    }

    public float getTongthang3() {
        return tongthang3;
    }

    public float getTongquy() {
        return tongquy;
    }

    public void setQuy(String quy) {
        this.quy = quy;
    }

    public void setTongthang1(float tongthang1) {
        this.tongthang1 = tongthang1;
    }

    public void setTongthang2(float tongthang2) {
        this.tongthang2 = tongthang2;
    }

    public void setTongthang3(float tongthang3) {
        this.tongthang3 = tongthang3;
    }

    public void setTongquy(float tongquy) {
        this.tongquy = tongquy;
    }

    @Override
    public String toString() {
        return "ThongKeQuy{" +
                "quy='" + quy + '\'' +
                ", tongthang1=" + tongthang1 +
                ", tongthang2=" + tongthang2 +
                ", tongthang3=" + tongthang3 +
                ", tongquy=" + tongquy +
                '}';
    }
}
