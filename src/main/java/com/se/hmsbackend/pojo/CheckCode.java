package com.se.hmsbackend.pojo;

import java.time.LocalDateTime;

public class CheckCode {
    private Integer id;
    private String code;
    private Integer type;
    private String email;
    private LocalDateTime time;

    public CheckCode() {
    }

    public CheckCode(Integer id, String code, Integer type, String email, LocalDateTime time) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.email = email;
        this.time = time;
    }

    @Override
    public String toString() {
        return "checkCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
