package com.feng.command.children;

import cn.hutool.core.bean.BeanUtil;
import com.feng.generate.FileGenerator;
import com.feng.model.template.CollapsarTemplateModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * ClassName: Generate
 * Package: com.feng.command
 * Description:
 * 接受用户输入的参数并生成代码
 * @Author Fengxd
 * @Create 2024/2/22 16:47
 * @Version 1.0
 */
@Data
@CommandLine.Command(name = "generate", description = "生成黑洞", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者",
            arity = "0..1", required = true, interactive = true, echo = true)
    private String author;

    @CommandLine.Option(names = {"-t", "--title"}, description = "网页标题", defaultValue = "WebGL 网页黑洞特效",
            interactive = true, echo = true)
    private String title = "WebGL 网页黑洞特效";

    @CommandLine.Option(names = {"-d", "--description"}, description = "网页描述", defaultValue = "一个炫酷的 WebGL 网页黑洞特效",
            interactive = true, echo = true)
    private String description = "一个炫酷的 WebGL 网页黑洞特效";

    @CommandLine.Option(names = {"-b", "--background"}, description = "背景图片",
            defaultValue = "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1427&q=80",
            interactive = true, echo = true)
    private String background = "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1427&q=80";

    @CommandLine.Option(names = {"-m", "--mass"}, description = "黑洞质量", defaultValue = "1500",
            interactive = true, echo = true)
    private double mass = 1500;

    @CommandLine.Option(names = {"-am", "--autoMove"}, description = "自动移动", defaultValue = "true",
            interactive = true, echo = true)
    private boolean autoMove = true;

    @CommandLine.Option(names = {"-mm", "--mouseMove"}, description = "跟随鼠标移动", defaultValue = "true",
            interactive = true, echo = true)
    private boolean mouseMove = true;

    @CommandLine.Option(names = {"-mlm", "--mouseLeaveMove"}, description = "鼠标离开后自动移动", defaultValue = "true",
            interactive = true, echo = true)
    private boolean mouseLeaveMove = true;

    @CommandLine.Option(names = {"-c", "--click"}, description = "鼠标点击动画", defaultValue = "true",
            interactive = true, echo = true)
    private boolean click = true;

    @CommandLine.Option(names = {"-tc", "--textColor"}, description = "字体颜色", defaultValue = "#000",
            interactive = true, echo = true)
    private String textColor = "#000";

    @CommandLine.Option(names = {"-ts", "--textSize"}, description = "字体大小", defaultValue = "16px",
            interactive = true, echo = true)
    private String textSize = "16px";
    @Override
    public Integer call() throws Exception {
        System.out.println("生成中...");
        CollapsarTemplateModel model = new CollapsarTemplateModel();
        BeanUtil.copyProperties(this, model);
        FileGenerator.generate(model);
        System.out.println("生成完成");
        return 0;
    }
}
