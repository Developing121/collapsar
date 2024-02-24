# Collapsar 定制化本地代码生成器
在本地生成一个定制化炫酷黑洞网页。
## 在命令行中运行中文乱码的问题
可以通过 JVM 的默认编码格式来解决
```shell
java -Dfile.encoding=utf-8 -jar xxx.jar
```