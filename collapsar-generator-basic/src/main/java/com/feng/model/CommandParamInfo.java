package com.feng.model;

import lombok.Data;

/**
 * ClassName: CommandParamInfo
 * Package: com.feng.model
 * Description:
 * 允许用户输入的命令参数信息
 * @Author Fengxd
 * @Create 2024/2/22 19:24
 * @Version 1.0
 */
@Data
public class CommandParamInfo {
    private String author;
    private String description;
    private Boolean required;
    private String defaultValue;
    public void setDefaultValue(String defaultValue) {
        if (defaultValue.contains("https://")){
            this.defaultValue = defaultValue.substring(0,10) + "..." +
                    defaultValue.substring(defaultValue.length() - 10);
        } else {
            this.defaultValue = defaultValue;
        }
    }
}
