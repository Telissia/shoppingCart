package com.teldrasill.pojo;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Goods
{
    private int id;
    private String gname;
    private int goodstype_id;
    private String gpicture;
    private CommonsMultipartFile logoImage;//用于保存用户上传的图片
    private double grprice;
    private double goprice;
    private int gstore;
    private String typename;//查询时使用

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public CommonsMultipartFile getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(CommonsMultipartFile logoImage) {
        this.logoImage = logoImage;
    }

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
