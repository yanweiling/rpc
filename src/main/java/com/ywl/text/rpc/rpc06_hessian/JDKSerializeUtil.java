package com.ywl.text.rpc.rpc06_hessian;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JDKSerializeUtil {
    public static void main(String[] args) {

    }

    public static byte[] jdkSerialize(Object o)throws Exception{
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream outputStream=new ObjectOutputStream(bos);
        outputStream.writeObject(o);
        outputStream.flush();
        byte[] bytes=bos.toByteArray();
        bos.close();
        outputStream.close();
        return bytes;
    }

    public static Object jdkDeserialize(byte[] bytes) throws Exception{
        ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
        ObjectInputStream inputStream=new ObjectInputStream(bis);
        Object o=inputStream.readObject();
        bis.close();
        inputStream.close();
        return o;
    }
}
