package com.silent.fiveghost.guide.beans;

/**
 * 认真的人到最后都是难过 2018/1/31.
 */

public class DateBeans {
    private String date;
    private String money;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public DateBeans(String date, String money) {

        this.date = date;
        this.money = money;
    }
}
