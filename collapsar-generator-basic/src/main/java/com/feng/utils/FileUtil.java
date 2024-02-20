package com.feng.utils;

import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * ClassName: FileUtil
 * Package: com.feng.utils
 * Description:
 * 操作文件工具类
 * @Author Fengxd
 * @Create 2024/2/20 8:57
 * @Version 1.0
 */
public class FileUtil {
    private FileUtil() {}
    /**
     * 把源文件复制到目标文件，如果目标文件已存在则替换它
     * @param input 源文件
     * @param output 目标文件
     */
    public static void copyFiles(File input, File output) {
        try {
            copy(input, output);
        } catch (IOException e) {
            System.err.println("复制文件失败");
            e.printStackTrace();
        }
    }

    /**
     * 把源文件复制到目标文件，如果目标文件已存在则替换它
     * @param input 源文件
     * @param output 目标文件
     * @throws IOException IOException
     */
    private static void copy(File input, File output) throws IOException {
        // 是否为目录
        if(input.isDirectory()) {
            File outputFile = new File(output, input.getName());
            // 不存在就创建目录
            if (!outputFile.exists() && !outputFile.mkdirs()) {
                System.err.println("目录创建失败");
            }
            // 获取目录下的所有子文件或子目录
            File[] files = input.listFiles();
            if (!ArrayUtil.isEmpty(files)) {
                // 递归复制
                for (File file : files) {
                    copy(file, outputFile);
                }
            }
        } else {
            // 是文件直接复制到指定目录
            /*
            Path resolve(String other): 这个方法接受一个 Path 对象作为参数，
            然后将其与当前的 Path 对象合并。如果 other 是一个绝对路径，
            那么这个方法会直接返回 other。如果 other 是一个相对路径，
            那么这个方法会将 other 添加到当前的 Path 对象的末尾。
             */
            Path outputPath = output.toPath().resolve(input.getName());
            Files.copy(input.toPath(), outputPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
