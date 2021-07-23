package com.ywl.text.rpc.rpc05;


import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

public class Client {
    public static void main(String[] args) {
        IUserService userService= (IUserService) Stub.getProxy(IUserService.class);
        User user=userService.findUserById(90);
        System.out.println(user);
    }
}
