package com.ywl.text.rpc.rpc06_hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.ywl.text.rpc.common.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class HessianUtil {
    public static void main(String[] args) throws Exception {
        User user=new User(1,"zhangsan");
        byte[] bytes=serialize(user);
        System.out.println("hessian序列化长度:"+bytes.length);
//        System.out.println("jdk序列化长度:"+JDKSerializeUtil.jdkSerialize(user).length);
        User user1= (User) deserialize(bytes);
        System.out.println(user1);
    }

    public static byte[] serialize(Object o)throws Exception{
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        Hessian2Output output=new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();
        byte[] bytes=baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

    public static Object deserialize(byte[] bytes)throws Exception{
        ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
        Hessian2Input input=new Hessian2Input(bis);
        Object result=input.readObject();
        bis.close();
        input.close();
        return result;
    }
}
