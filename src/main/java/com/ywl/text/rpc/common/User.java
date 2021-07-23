package com.ywl.text.rpc.common;

import java.io.Serializable;

/**
 * socket传输，需要将对象以二进制的方式发送，
 * 接收方收到二进制，再转换成对象；
 * 所以就需要对象进行序列化
 * Serializable 是jdk自带的序列化方式,这种序列化方式只支持java语言，序列化以后，长度特别长
 */
public class User implements Serializable{
    private static final long serialVersionUID=1l;

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
