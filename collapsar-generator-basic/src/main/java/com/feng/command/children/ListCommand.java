package com.feng.command.children;

import picocli.CommandLine;

/**
 * ClassName: ListCommand
 * Package: com.feng.command
 * Description:
 * 输出要生成文件的文件列表
 * @Author Fengxd
 * @Create 2024/2/22 16:46
 * @Version 1.0
 */
@CommandLine.Command(name = "list", description = "文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("文件列表...");
    }
}
