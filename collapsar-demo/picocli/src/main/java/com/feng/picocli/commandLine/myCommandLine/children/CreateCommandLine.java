package com.feng.picocli.commandLine.myCommandLine.children;

import picocli.CommandLine;

/**
 * ClassName: AddCommandLine
 * Package: com.feng.picocli.commandLine.myCommandLine.children
 * Description:
 *
 * @Author Fengxd
 * @Create 2024/2/21 16:06
 * @Version 1.0
 */
@CommandLine.Command(name = "Create", description = "添加", mixinStandardHelpOptions = true)
public class CreateCommandLine implements Runnable{
    @Override
    public void run() {
        System.out.println("Create...");
    }
}
