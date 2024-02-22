package com.feng.command;

import com.feng.command.children.ConfigCommand;
import com.feng.command.children.GenerateCommand;
import com.feng.command.children.ListCommand;
import picocli.CommandLine;

/**
 * ClassName: CommandExecutor
 * Package: com.feng.command.children
 * Description:
 * 绑定所有子命令并提供执行命令的方法
 * @Author Fengxd
 * @Create 2024/2/22 16:49
 * @Version 1.0
 */
@CommandLine.Command(name = "collapsar", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{
    private final CommandLine commandLine;

    public CommandExecutor() {
        this.commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        System.out.println("无效的命令，输入 --help 查看命令提示");
    }

    public Integer execute(String[] args) {
        return commandLine.execute(args);
    }
}
