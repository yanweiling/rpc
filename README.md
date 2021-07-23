## 对象序列化方式

1.java.io.Serialize
2.Hessian
3.google protobuf
4.facebook Thrif
5.kyro
6.fst
7.json序列化框架
  1.Jackson
  2.google Gson
  3.Ali FastJson
8.xmlrpc（xtream）

对性能敏感，对开发体验要求不高的内部系统。
　　thrift/protobuf

对开发体验敏感，性能有要求的内外部系统。
　　hessian2

对序列化后的数据要求有良好的可读性
　　jackson/gson/xml  


RPC:本质就是采用某一种协议进行通讯，将对象序列化，以字节数组的方式进行传输通信；并且采用了代理设计模式封装了通信的细节

dubbo采用的是socket

---
从单机走向分布式，有很多分布式的通信方式
1，最古老，永不过时的，TCP/UDP的二进制传输。
     其实所有的通信方式归根结底都是TCP/UDP
2.CORBA Common Object Request Broker Architecture。古老而复杂的，支持面向对象的通信协议---支持多种语言--非常复杂：复杂的东西不适合互联网
3.WebService 基于http+xml的标准化Web Api
4.Restful  http+json
5.RMI Remote Mthod Invocation ：java内部的分布式通信协议
6.JMS :Java Mssage Serivce  ：JavaEE中的消息框架标准，为很多MQ所支持
7.RPC ：Remote Procedure Call：是个概念，是一种远程通信方式，具体实现有很多种
