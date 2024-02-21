package com.feng.generate;

import com.feng.utils.FileGeneratorUtil;

import java.io.File;

/**
 * ClassName: DynamicFileGenerator
 * Package: com.feng.generate
 * Description:
 * 动态文件生成器
 * @Author Fengxd
 * @Create 2024/2/20 13:16
 * @Version 1.0
 */
public class FileGenerator {
    private FileGenerator() {}
    /**
     * 根据模板文件和提供的模板数据生成 Java 模板项目
     * @param model 模板文件的数据
     */
    public static void generate(Object model) {
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 获取项目根路径
        String rootPath = new File(projectPath).getParentFile().getPath();
        // 获取文件输入路径
        File inputFile = new File(rootPath + "/collapsar-generator-template/acm-template");
        // 获取文件输出路径
        File outputFile = new File(rootPath);
        // 生成静态文件
        FileGeneratorUtil.doStaticFileGenerator(inputFile,outputFile);
        // 获取模板文件输入路径
        String templateInputPath = projectPath + "/src/main/resources/templates/MainTemplate.java.ftl";
        // 获取模板文件的输出路径
        String fileOutputPath = outputFile.getPath() + "/" + inputFile.getName() + "/src/com/feng/acm/MainTemplate.java";
        // 生成动态文件
        FileGeneratorUtil.doDynamicFileGenerator(templateInputPath,fileOutputPath,model);
    }

}
