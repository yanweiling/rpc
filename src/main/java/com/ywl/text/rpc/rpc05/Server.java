package com.ywl.text.rpc.rpc05;


import com.ywl.text.rpc.common.User;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running=true;

    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(8888);
        while(running){
            Socket s=ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    private  static void process(Socket s) throws Exception {
        InputStream is=s.getInputStream();
        OutputStream out=s.getOutputStream();
        //如果想要读取对象
        ObjectInputStream ois=new ObjectInputStream(is);
        ObjectOutputStream oos=new ObjectOutputStream(out);

        String className=ois.readUTF();
        System.out.println("读取到的className:"+className);
        //读取方法名
        String methodName=ois.readUTF();
        //读取参数类型
        Class[] parametersType= (Class[]) ois.readObject();
        //读取参数
        Object[] args= (Object[]) ois.readObject();

        //todo 从服务注册表中找到具体的实现类
        Class clazz=null;
        clazz=UserSerivceImpl.class;//或者从spring容器中，获取到接口的实现实例

        Method method=clazz.getMethod(methodName,parametersType);
        System.out.println("开始调度方法:"+method.getName());

        User user= (User) method.invoke(clazz.newInstance(),args);
        oos.writeObject(user);
        oos.flush();
        System.out.println("写出数据");
    }
}
