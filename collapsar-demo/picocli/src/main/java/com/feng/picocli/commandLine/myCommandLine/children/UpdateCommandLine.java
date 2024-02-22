package com.feng.picocli.commandLine.myCommandLine.children;

import picocli.CommandLine;

/**
 * ClassName: UpdateCommandLine
 * Package: com.feng.picocli.commandLine.myCommandLine.children
 * Description:
 *
 * @Author Fengxd
 * @Create 2024/2/21 16:07
 * @Version 1.0
 */
@CommandLine.Command(name = "Update", description = "更新", mixinStandardHelpOptions = true)
public class UpdateCommandLine implements Runnable{
    @Override
    public void run() {
        System.out.println("Update...");
    }
}
