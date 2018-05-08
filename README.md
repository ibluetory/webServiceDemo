# Java 调用 wsdl 形式的 webservice
## 项目背景
一个B/S结构的java项目，需要集成海康的视频监控系统。

## github地址

[https://github.com/ibluetory/webServiceDemo](https://github.com/ibluetory/webServiceDemo/)

## 海康平台

1. 海康平台版本 Cms_V4.3 v9800
2. 平台webservice接口地址： http://ip:port/vms/services/VmsSdkWebService?wsdl

## axis技术
1. 使用版本 axis 1.4
2. 下载地址 http://mirrors.hust.edu.cn/apache/axis/axis/java/1.4/

## 使用到的lib
如果少了包，调用的时候会出现异常

- axis.jar
- commons-discovery-0.2.jar
- commons-logging-1.2.jar
- dom4j-1.6.1.jar
- hik-util-1.0.0.jar
- jaxen-1.1.4.jar
- jaxrpc.jar
- log4j-1.2.16.jar
- saaj.jar
- wsdl4j-1.5.1.jar
- xmlpull-1.1.3.1.jar
- xstream-1.4.3.jar
