package com.feng.picocli.commandLine.myCommandLine.children;

import picocli.CommandLine;

/**
 * ClassName: DeleteCommandLine
 * Package: com.feng.picocli.commandLine.myCommandLine.children
 * Description:
 *
 * @Author Fengxd
 * @Create 2024/2/21 16:06
 * @Version 1.0
 */
@CommandLine.Command(name = "Delete",description = "删除", mixinStandardHelpOptions = true)
public class DeleteCommandLine implements Runnable{
    @Override
    public void run() {
        System.out.println("Delete...");
    }
}
