package org.francis.dd.service;

import org.francis.dd.Entity.User;
import org.francis.dd.annotation.DataSource;
import org.francis.dd.datasource.DataSourceType;
import org.francis.dd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @DataSource(value = DataSourceType.DS_SLAVE)
    public List<User> getUsers(){
        List<User> users = userMapper.getUsers();
        System.out.println("users = " + users);
        return users;
    }
}
