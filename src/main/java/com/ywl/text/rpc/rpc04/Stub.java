package com.ywl.text.rpc.rpc04;



import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                oos.writeUTF(method.getName());
                oos.writeObject(method.getParameterTypes());
                oos.writeObject(args);
                oos.flush();


                //从socket服务中读入数据
                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                User user= (User) ois.readObject();
                oos.close();
                ois.close();
                socket.close();
                return user;
            }
        });

    }

}
