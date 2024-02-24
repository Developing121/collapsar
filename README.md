# Collapsar 定制化本地代码生成器
持续更新中~

## 介绍
一个基本的代码生成器,允许通过用户指定的参数,在本地生成一个定制化的炫酷黑洞网页。

## 目录结构
| 目录                        | 描述    |
|---------------------------|-------|
| collapsar-demo            | 草稿    |
| collapsar-generator-basic | 代码生成器 |
| collapsar-generator-template    | 模板    |

## 技术选型
- picocli
- freemarker

## 使用
1.进入 collapsar-generator-basic 目录,执行命令:
```shell
mvn clean package
```

## 在命令行中运行中文乱码的问题
可以通过 JVM 的默认编码格式来解决
```shell
java -Dfile.encoding=utf-8 -jar xxx.jar
```
