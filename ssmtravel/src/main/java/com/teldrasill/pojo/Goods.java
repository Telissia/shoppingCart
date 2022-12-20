package com.teldrasill.pojo;

public class Goods
{
    private int id;
    private String gname;
    private int goodstype_id;
    private String gpicture;
    private double grprice;
    private double goprice;
    private int gstore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGoodstype_id() {
        return goodstype_id;
    }

    public void setGoodstype_id(int goodstype_id) {
        this.goodstype_id = goodstype_id;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public double getGrprice() {
        return grprice;
    }

    public void setGrprice(double grprice) {
        this.grprice = grprice;
    }

    public double getGoprice() {
        return goprice;
    }

    public void setGoprice(double goprice) {
        this.goprice = goprice;
    }

    public int getGstore() {
        return gstore;
    }

    public void setGstore(int gstore) {
        this.gstore = gstore;
    }
}
