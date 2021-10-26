package com.franc1s.springbootvalidation.model;

import com.franc1s.springbootvalidation.validation.ValidationGroup1;
import com.franc1s.springbootvalidation.validation.ValidationGroup2;

import javax.validation.constraints.*;

//message也可以直接写字符串
public class User {
    private Long id;
    @Size(min = 5, max = 8, message = "{user.name.size}",groups = ValidationGroup1.class)
    private String name;
    @DecimalMin(value = "1", message = "{user.age.min}",groups = ValidationGroup1.class)
    @DecimalMax(value = "200", message = "{user.age.max}",groups = ValidationGroup1.class)
    private Integer age;
    @NotNull(message = "{user.address.notnull}",groups = {ValidationGroup2.class,ValidationGroup1.class})
    private String address;
    @NotNull(message = "{user.email.notnull}")
    @Email(message = "{user.email.pattern}")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
