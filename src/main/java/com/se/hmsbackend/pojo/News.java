package com.se.hmsbackend.pojo;

public class News {
    private Integer id;
    private String img;
    private String body;

    public News() {
    }

    public News(Integer id, String img, String body) {
        this.id = id;
        this.img = img;
        this.body = body;
    }

    @Override
    public String toString() {
        return "news{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
