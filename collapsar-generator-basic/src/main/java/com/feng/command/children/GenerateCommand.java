package com.feng.command.children;

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
@CommandLine.Command(name = "generate", description = "生成黑洞", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者",
            arity = "0..1", required = true, interactive = true, echo = true)
    private String author;

    @CommandLine.Option(names = {"-t", "--title"}, description = "网页标题", defaultValue = "WebGL 网页黑洞特效",
            interactive = true, echo = true)
    private String title;

    @CommandLine.Option(names = {"-d", "--description"}, description = "网页描述", defaultValue = "一个炫酷的 WebGL 网页黑洞特效",
            interactive = true, echo = true)
    private String description;

    @CommandLine.Option(names = {"-b", "--background"}, description = "背景图片",
            defaultValue = "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1427&q=80",
            interactive = true, echo = true)
    private String background;

    @CommandLine.Option(names = {"-m", "--mass"}, description = "黑洞质量", defaultValue = "1500",
            interactive = true, echo = true)
    private double mass;

    @CommandLine.Option(names = {"-am", "--autoMove"}, description = "自动移动", defaultValue = "true",
            interactive = true, echo = true)
    private boolean autoMove;

    @CommandLine.Option(names = {"-mm", "--mouseMove"}, description = "跟随鼠标移动", defaultValue = "true",
            interactive = true, echo = true)
    private boolean mouseMove;

    @CommandLine.Option(names = {"-mlm", "--mouseLeaveMove"}, description = "鼠标离开后自动移动", defaultValue = "true",
            interactive = true, echo = true)
    private boolean mouseLeaveMove;

    @CommandLine.Option(names = {"-c", "--click"}, description = "鼠标点击动画", defaultValue = "true",
            interactive = true, echo = true)
    private boolean click;

    @CommandLine.Option(names = {"-tc", "--textColor"}, description = "字体颜色", defaultValue = "#000",
            interactive = true, echo = true)
    private String textColor;

    @CommandLine.Option(names = {"-ts", "--textSize"}, description = "字体大小", defaultValue = "16px",
            interactive = true, echo = true)
    private String textSize;
    @Override
    public Integer call() throws Exception {
        System.out.println("生成...");
        System.out.println(author);
        System.out.println(title);
        System.out.println(description);
        System.out.println(background);
        System.out.println(mass);
        System.out.println(autoMove);
        System.out.println(mouseMove);
        System.out.println(mouseLeaveMove);
        System.out.println(click);
        System.out.println(textColor);
        System.out.println(textSize);
        return 0;
    }
}
