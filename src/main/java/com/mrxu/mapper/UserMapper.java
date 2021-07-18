package com.mrxu.mapper;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/1 16:35
 */

import com.mrxu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Long id);

    @Select("select * from user")
    List<User> getUsers();

    @Update("update user set name = #{name},age = #{age} where id = #{id}")
    Integer update(User user);

    @Insert("insert into user (id,name,age) values (#{id},#{name},#{age})")
    Integer insert(User user);

    @Insert("delete from user where id = #{id}")
    Integer delete(@Param("id") Long id);
}
