package com.silent.fiveghost.guide.beans;

/**
 * Created by Lenovo on 2018/1/27.
 */

public class HomeItemBean {
    private String image;
    private String cityname;
    private String time;
    private String number;
    private String love;
    private String tv_order_type;

    @Override
    public String toString() {
        return "HomeItemBean{" +
                "image='" + image + '\'' +
                ", cityname='" + cityname + '\'' +
                ", time='" + time + '\'' +
                ", number='" + number + '\'' +
                ", love='" + love + '\'' +
                ", tv_order_type='" + tv_order_type + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getTv_order_type() {
        return tv_order_type;
    }

    public void setTv_order_type(String tv_order_type) {
        this.tv_order_type = tv_order_type;
    }

    public HomeItemBean(String cityname, String time, String number, String love, String tv_order_type) {
        this.cityname = cityname;
        this.time = time;
        this.number = number;
        this.love = love;
        this.tv_order_type = tv_order_type;
    }

    public HomeItemBean(String image, String cityname, String time, String number, String love, String tv_order_type) {
        this.image = image;
        this.cityname = cityname;
        this.time = time;
        this.number = number;
        this.love = love;
        this.tv_order_type = tv_order_type;
    }
}