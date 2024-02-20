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
public class FileGeneratorTest {
    @Test
    public void testgenerate() {
        MainTemplateModel model = new MainTemplateModel();
        model.setAuthor("Fengxd");
        model.setLoop(true);
        FileGenerator.generate(model);
    }
}
