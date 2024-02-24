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
//        String rootPath = new File(projectPath).getParentFile().getPath();
        // 获取文件输入路径
        File inputFile = new File(projectPath + "/collapsar-generator-template/collapsar");
        // 获取文件输出路径
        File outputFile = new File(projectPath);
        // 生成静态文件
        FileGeneratorUtil.doStaticFileGenerator(inputFile,outputFile);
        // 获取模板文件输入路径
        String indexInputPath = projectPath + "/collapsar-generator-basic/src/main/resources/templates/collapsar/indexTemplate.html.ftl";
        String scriptInputPath = projectPath + "/collapsar-generator-basic/src/main/resources/templates/collapsar/scriptTemplate.js.ftl";
        String styleInputPath = projectPath + "/collapsar-generator-basic/src/main/resources/templates/collapsar/styleTemplate.css.ftl";
        // 获取模板文件的输出路径
        String indexOutputPath = outputFile.getPath() + "/" + inputFile.getName() + "/index.html";
        String scriptOutputPath = outputFile.getPath() + "/" + inputFile.getName() + "/script.js";
        String styleOutputPath = outputFile.getPath() + "/" + inputFile.getName() + "/style.css";
        // 生成动态文件
        FileGeneratorUtil.doDynamicFileGenerator(indexInputPath,indexOutputPath,model);
        FileGeneratorUtil.doDynamicFileGenerator(scriptInputPath,scriptOutputPath,model);
        FileGeneratorUtil.doDynamicFileGenerator(styleInputPath,styleOutputPath,model);
    }

}
