package com.feng.generate;

import com.feng.model.MainTemplateModel;
import org.junit.Test;

/**
 * ClassName: DynamicFileGeneratorTest
 * Package: com.feng.generate
 * Description:
 *
 * @Author Fengxd
 * @Create 2024/2/20 14:12
 * @Version 1.0
 */
public class DynamicFileGeneratorTest {
    @Test
    public void testGenerate() {
        MainTemplateModel testMainTemplateModel = new MainTemplateModel();
        DynamicFileGenerator.generate("C:\\Users\\24672\\code\\collapsar\\collapsar-generator-basic\\src\\main\\resources\\templates\\MainTemplate.java.ftl",
                "MainTemplate.java", testMainTemplateModel);
    }
}
