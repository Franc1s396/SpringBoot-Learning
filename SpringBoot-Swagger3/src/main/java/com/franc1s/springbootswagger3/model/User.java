package com.franc1s.springbootswagger3.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户实体类",description = "这个类定义了用户的所有属性")
public class User {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "用户名字")
    private String name;
    @ApiModelProperty(value = "用户地址")
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
