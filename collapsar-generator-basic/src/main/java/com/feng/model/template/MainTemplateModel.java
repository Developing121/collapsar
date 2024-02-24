package com.feng.model.template;

import lombok.Data;

/**
 * ClassName: Model
 * Package: com.feng
 * Description:
 * MainTemplate 模板文件的数据
 * @Author Fengxd
 * @Create 2024/2/20 14:21
 * @Version 1.0
 */
@Data
public class MainTemplateModel {
    /**
     * 作者
     */
    private String author = "Fengxd";

    /**
     * 是否开启循环
     */
    private boolean loop = false;

    /**
     * 输出文本
     */
    private String outputText = "sum：";
}
