package com.feng.picocli.commandLine.myCommandLine.children;

import picocli.CommandLine;

/**
 * ClassName: ReadCommandLine
 * Package: com.feng.picocli.commandLine.myCommandLine.children
 * Description:
 *
 * @Author Fengxd
 * @Create 2024/2/21 16:07
 * @Version 1.0
 */
@CommandLine.Command(name = "Read", description = "查找", mixinStandardHelpOptions = true)
public class ReadCommandLine implements Runnable{
    @Override
    public void run() {
        System.out.println("Read...");
    }
}
