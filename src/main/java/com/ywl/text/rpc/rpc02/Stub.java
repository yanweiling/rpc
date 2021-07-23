package com.ywl.text.rpc.rpc02;



import com.ywl.text.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Stub {

    public User findUserById(Integer id) throws IOException {
        Socket s=new Socket("127.0.0.1",8888);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(baos);

        dos.writeInt(id);
        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis=new DataInputStream(s.getInputStream());
        int id2=dis.readInt();
        String name=dis.readUTF();

        User user=new User(id2,name);
        System.out.println(user);

        dos.close();
        s.close();

        return user;
    }
}
