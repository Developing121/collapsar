package com.feng.utils;

import cn.hutool.core.util.ArrayUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * ClassName: FileGeneratorUtil
 * Package: com.feng.utils
 * Description:
 * 模板项目生成辅助工具
 * @Author Fengxd
 * @Create 2024/2/20 15:59
 * @Version 1.0
 */
public class FileGeneratorUtil {
    /**
     * 把源文件复制到目标文件，如果目标文件已存在则替换它
     * @param input 源文件
     * @param output 目标文件
     */
    public static void doStaticFileGenerator(File input, File output) {
        try {
            staticFileGenerator(input, output);
        } catch (IOException e) {
            System.err.println("静态文件复制失败");
            e.printStackTrace();
        }
    }

    /**
     * 根据模板文件及模板数据生成文件
     * @param templatePath 模板文件路径
     * @param outputFilePath 输入文件路径
     * @param model 模板文件参数
     */
    public static void doDynamicFileGenerator(String templatePath, String outputFilePath,
                                              Object model) {
        try {
            dynamicFileGenerator(templatePath, outputFilePath, model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            System.err.println("动态文件复制失败");
            e.printStackTrace();
        }
    }

    /**
     * 把源文件复制到目标文件，如果目标文件已存在则替换它
     * @param input 源文件
     * @param output 目标文件
     * @throws IOException IOException
     */
    private static void staticFileGenerator(File input, File output) throws IOException {
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
                    staticFileGenerator(file, outputFile);
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

    /**
     * 根据模板文件及模板数据生成文件
     * @param templatePath 模板文件路径
     * @param outputFilePath 输入文件路径
     * @param model 模板文件参数
     * @throws IOException IOException
     * @throws TemplateException TemplateException
     */
    private static void dynamicFileGenerator(String templatePath, String outputFilePath,
                                             Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateFile = new File(templatePath);
        // 设置模板文件使用的数字格式
        configuration.setNumberFormat("0.######");
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(templateFile.getParentFile());

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate(templateFile.getName());

        Writer out = new FileWriter(outputFilePath);
        template.process(model, out);
        // 生成文件后并关闭
        out.close();
    }
}
