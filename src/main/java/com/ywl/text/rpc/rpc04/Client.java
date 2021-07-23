package com.ywl.text.rpc.rpc04;


import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

public class Client {
    public static void main(String[] args) {
        IUserService userService= Stub.getProxy();
        User user=userService.findUserById(90);
        System.out.println(user);
    }
}
