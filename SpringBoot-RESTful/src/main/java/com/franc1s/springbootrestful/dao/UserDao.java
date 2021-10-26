package com.franc1s.springbootrestful.dao;

import com.franc1s.springbootrestful.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//将地址中的users改成people
@RepositoryRestResource(path = "people")
public interface UserDao extends JpaRepository<User,Long> {
    //path表示rest访问该方法时的名字
    @RestResource(path = "byname")
    List<User> findUserByUsernameIs(@Param("username") String username);
}
