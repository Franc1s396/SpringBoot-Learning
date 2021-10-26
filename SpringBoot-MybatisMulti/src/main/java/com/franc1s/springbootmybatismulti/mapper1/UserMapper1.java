package com.franc1s.springbootmybatismulti.mapper1;

import com.franc1s.springbootmybatismulti.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper1 {
    List<User> findAll();
}
