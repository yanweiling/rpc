package com.ywl.text.rpc.rpc03;


import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static IUserService getProxy(){
        return (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class<?>[]{IUserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("调用方法:"+method.getName());
                Socket socket=new Socket("127.0.0.1",8888);
                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                DataOutputStream dos=new DataOutputStream(bos);
                dos.write(10);
                //往socket中写出信息
                socket.getOutputStream().write(bos.toByteArray());
                socket.getOutputStream().flush();

                //从socket服务中读入数据
                DataInputStream dis=new DataInputStream(socket.getInputStream());
                int id=dis.readInt();
                String name=dis.readUTF();
                User user=new User(id,name);
                return user;
            }
        });

    }

}
