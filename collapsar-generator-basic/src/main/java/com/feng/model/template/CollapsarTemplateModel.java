package com.feng.model.template;

import lombok.Data;

/**
 * ClassName: CollapsarTemplateModel
 * Package: com.feng.model.template
 * Description:
 * 黑洞模板文件的填充数据
 * @Author Fengxd
 * @Create 2024/2/24 11:44
 * @Version 1.0
 */
@Data
public class CollapsarTemplateModel {
    private String author;
    private String title;
    private String description;
    private String background;
    private double mass;
    private boolean autoMove;
    private boolean mouseMove;
    private boolean mouseLeaveMove;
    private boolean click;
    private String textColor;
    private String textSize;
}
