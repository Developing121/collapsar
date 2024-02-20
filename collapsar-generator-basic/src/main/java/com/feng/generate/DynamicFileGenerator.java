package com.feng.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * ClassName: DynamicFileGenerator
 * Package: com.feng.generate
 * Description:
 * 动态文件生成器
 * @Author Fengxd
 * @Create 2024/2/20 13:16
 * @Version 1.0
 */
public class DynamicFileGenerator {
    public static void generate(String templatePath, String outputFileName, Object model) {
        try {
            maker(templatePath, outputFileName, model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            System.err.println("文件生成失败");
            e.printStackTrace();
        }
    }

    private static void maker(String templatePath, String outputFileName, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateFile = new File(templatePath);
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(templateFile.getParentFile());

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate(templateFile.getName());

        Writer out = new FileWriter(outputFileName);
        template.process(model, out);
        // 生成文件后并关闭
        out.close();
    }
}
