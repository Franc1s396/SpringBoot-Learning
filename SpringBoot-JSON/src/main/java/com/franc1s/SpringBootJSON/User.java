package com.franc1s.SpringBootJSON;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

//批量忽略
//@JsonIgnoreProperties({"address","birthday"})
public class User {
    //指定属性序列化/反序列化时的名称，默认名称是属性名
    //index是展示时的优先级
    @JsonProperty(value = "aaage",index = 99)
    private Integer age;
    private String name;
    //日期格式化,注意时区问题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date birthday;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
