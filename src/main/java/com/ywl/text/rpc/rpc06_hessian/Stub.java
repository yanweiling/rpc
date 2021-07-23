package com.ywl.text.rpc.rpc06_hessian;


import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.ywl.text.rpc.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static Object getProxy(Class clazz){
        return  Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("调用方法:"+method.getName());
                System.out.println(proxy.getClass().getName());
                Socket socket=new Socket("127.0.0.1",8888);
//                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                Hessian2Output oos=new Hessian2Output(socket.getOutputStream());
                oos.writeString(clazz.getName());
                oos.writeString(method.getName());
                oos.writeObject(method.getParameterTypes());
                oos.writeObject(args);
                oos.flush();


                //从socket服务中读入数据
//                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                Hessian2Input input=new Hessian2Input(socket.getInputStream());
                User user= (User) input.readObject();
                oos.close();
                input.close();
                socket.close();
                return user;
            }
        });

    }

}
