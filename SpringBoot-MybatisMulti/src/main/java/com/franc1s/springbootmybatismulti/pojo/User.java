package com.franc1s.springbootmybatismulti.pojo;

public class User {
    private Integer id;
    private String name;
    private String pwd;
    private Integer enabled;

    public User() {
    }

    public User(Integer id, String name, String pwd, Integer enabled) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", enabled=" + enabled +
                '}';
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
