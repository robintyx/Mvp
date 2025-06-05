## 使用说明文档地址
https://www.yuque.com/docs/share/4ced28d1-d8b1-4494-9ac2-36cef1916a44?#
（密码：dug8） 

## 使用knife4j
https://doc.xiaominfo.com/knife4j/documentation/enhance.html

## 接口文档
http://localhost:8083/demo/doc.html#/home


## 应用命名规范
1、当重名后可以进行缩写，取部分字段，取部分功能，增加子模块，取随机数(尽量不要使用且不超过3级，不然名字会很长，导致域名/应用名等都很长)等，尽量看名字就知道应用做什么的
例如：microvideo-shz-hbms
2、应用名唯一性(部署在k8s里的应用)：应用以通过匹配k8s里的namespace保证唯一性