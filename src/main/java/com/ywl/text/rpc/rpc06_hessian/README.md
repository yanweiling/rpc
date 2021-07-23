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