package com.mrxu.service;

import com.mrxu.common.Result;
import com.mrxu.entity.User;

import java.util.List;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/1 16:39
 */
public interface UserService {
    Result<List<User>> findAll(String env);
    Result<User> findById(String env,Long id);
    Result<Integer> insert(String env,User user);
    Result<Integer> update(String env,User user);
    Result<Integer> delete(String env,Long id);
}
