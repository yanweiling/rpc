package com.ywl.text.rpc.rpc06_hessian;


import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

public class UserSerivceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id,"张三");
    }
}
