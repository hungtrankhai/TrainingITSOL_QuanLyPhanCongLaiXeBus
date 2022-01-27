package com.java.phanconglaixebus.entity;

public enum Level {
    A(1), B(2), C(3), D(4),E(5),F(6);
    private Integer code;

    Level(Integer  code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    Level() {

    }
}
