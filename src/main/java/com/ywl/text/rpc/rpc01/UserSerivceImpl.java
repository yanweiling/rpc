package com.ywl.text.rpc.rpc01;


import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

public class UserSerivceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(33,"张三");
    }
}
