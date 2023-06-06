package com.se.hmsbackend.pojo;

import java.time.LocalDate;

public class News {
    private Integer id;
    private String img;
    private String body;
    private LocalDate date;

    public News() {
    }

    public News(Integer id, String img, String body, LocalDate date) {
        this.id = id;
        this.img = img;
        this.body = body;
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
