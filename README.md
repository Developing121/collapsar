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
- 
## 使用
1.进入 collapsar-generator-basic 目录,执行命令:
```shell
mvn clean package
```
2.进入 collapsar-generator-basic 目录的父目录(jar 所在的目录),执行命令:
```shell
generator generate --help
```
3.根据命令行提示,输入参数,生成代码

4.查看其他命令
```shell
generator --help
```
