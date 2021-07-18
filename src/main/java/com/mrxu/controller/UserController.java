package com.mrxu.controller;

import com.mrxu.common.Result;
import com.mrxu.entity.User;
import com.mrxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author jlxu@telenav.cn
 * @date 2021/7/1 15:37
 */
@RestController
@CrossOrigin
@RequestMapping("/user/{env}")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public Result<User> findUserById(@PathVariable(name = "env") String env, @PathVariable(name = "id") Long id) {
        return service.findById(env, id);
    }

    @GetMapping
    public Result<List<User>> findAll(@PathVariable(name = "env") String env) {
        return service.findAll(env);
    }

    @PutMapping
    public Result<Integer> update(@PathVariable(name = "env") String env, @RequestBody User user) {
        return service.update(env, user);
    }

    @DeleteMapping("/{id}")
    public Result<Integer> delete(@PathVariable(name = "env") String env, @PathVariable Long id) {
        return service.delete(env, id);
    }

    @PostMapping
    public Result<Integer> insert(@PathVariable(name = "env") String env, @RequestBody User user) {
        return service.insert(env, user);
    }

}
