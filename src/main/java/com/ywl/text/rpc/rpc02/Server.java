package com.ywl.text.rpc.rpc02;


import com.ywl.text.rpc.common.IUserService;
import com.ywl.text.rpc.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running=true;

    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8888);
        while(running){
            Socket s=ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    private  static void process(Socket s) throws IOException {
        InputStream is=s.getInputStream();
        OutputStream out=s.getOutputStream();
        DataInputStream dis=new DataInputStream(is);
        DataOutputStream dos=new DataOutputStream(out);

        int id=dis.readInt();
        System.out.println("收到"+id);
        IUserService service=new UserSerivceImpl();
        User user=service.findUserById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
        System.out.println("写出数据");
    }
}
