package com.mrxu.service.impl;

import com.mrxu.common.Result;
import com.mrxu.config.DatabaseContextHolder;
import com.mrxu.config.DatabaseType;
import com.mrxu.entity.User;
import com.mrxu.mapper.UserMapper;
import com.mrxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/1 16:39
 */

@Primary
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public Result<List<User>> findAll(String env) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.valueOf(env));
        return Result.success(mapper.getUsers());
    }

    @Override
    public Result<User> findById(String env,Long id) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.valueOf(env));
        return Result.success(mapper.getUserById(id));
    }

    @Override
    public Result<Integer> insert(String env,User user) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.valueOf(env));
        return Result.success(mapper.insert(user));
    }

    @Override
    public Result<Integer> update(String env,User user) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.valueOf(env));
        return Result.success(mapper.update(user));
    }

    @Override
    public Result<Integer> delete(String env,Long id) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.valueOf(env));
        return Result.success(mapper.delete(id));
    }
}
