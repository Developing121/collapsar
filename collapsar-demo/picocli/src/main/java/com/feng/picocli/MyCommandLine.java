package com.feng.picocli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * ClassName: CommandLine
 * Package: com.feng.picocli
 * Description:
 * 命令行类
 * @Author Fengxd
 * @Create 2024/2/21 15:41
 * @Version 1.0
 */
// 2.使用 @Command 注解标记该类并为其命名，mixinStandardHelpOptions 属性设置为 true 可以给应用程序自动添加 --help 和 --version 选项。
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class MyCommandLine implements Runnable{// 1.实现 Runnable 接口或 Callable 接口
    // 3.通过 @Option 注解将字段设置为命令行选项，可以给选项设置名称和描述。
    @Option(names = { "-s", "--font-size" }, description = "Font size", interactive = true, required = true)
    int fontSize = 19;

    @Option(names = { "-n", "--name"}, description = "Enter your name", interactive = true, required = true)
    String name;

    // 4.通过 @Parameters 注解将字段设置为命令行参数，可以指定默认值、描述等信息。
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" }; // 5.Picocli 会将命令行参数转换为强类型值，并自动注入到注解字段中。

    @Override
    public void run() {
        // 6.在类的 run 或 call 方法中定义业务逻辑，当命令解析成功（用户敲了回车）后被调用。
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("name = " + name);
        System.out.println("words = " + String.join(",", words));
    }
}
