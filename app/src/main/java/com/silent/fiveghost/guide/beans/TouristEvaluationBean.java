package com.silent.fiveghost.guide.beans;

/**
 * 认真的人到最后都是难过 2018/1/28.
 */

public class TouristEvaluationBean {
    private String iamge_url;
    private String name;
    private String time;
    private String content;

    public TouristEvaluationBean(String iamge_url, String name, String time, String content) {
        this.iamge_url = iamge_url;
        this.name = name;
        this.time = time;
        this.content = content;
    }

    @Override
    public String toString() {
        return "YouKePingJiaBean{" +
                "iamge_url='" + iamge_url + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setIamge_url(String iamge_url) {
        this.iamge_url = iamge_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIamge_url() {

        return iamge_url;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }
}
