package com.feng;

import com.feng.utils.FileUtil;

import java.io.File;
import java.io.IOException;

/**
* ClassName: ${NAME}
* Package: com.feng
* Description: 
* @Author Fengxd
* @Create 2024/2/18 21:29 
* @Version 1.0
*/
public class Main {
    public static void main(String[] args) {
        /*
        静态文件生成
        1.获取输入文件路径
        2.获取输出文件路径
        3.使用 hutool copy 文件
         */
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath);
        // 输入路径
        String inputPath = new File(parentFile, "collapsar-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        try {
            FileUtil.copy(new File(inputPath), parentFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}