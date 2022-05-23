package org.francis.dd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.francis.dd.Entity.User;

import java.util.List;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
}
