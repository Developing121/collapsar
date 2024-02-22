package com.feng.picocli;

import com.feng.picocli.commandLine.myCommandLine.MyCommandLine;
import com.feng.picocli.commandLine.myCommandLine.children.CreateCommandLine;
import com.feng.picocli.commandLine.myCommandLine.children.DeleteCommandLine;
import com.feng.picocli.commandLine.myCommandLine.children.ReadCommandLine;
import com.feng.picocli.commandLine.myCommandLine.children.UpdateCommandLine;
import com.feng.picocli.utils.ParameterCheckerUtil;
import picocli.CommandLine;

import java.util.Arrays;

/**
 * ClassName: Main
 * Package: com.feng.picocli
 * Description:
 *
 * @Author Fengxd
 * @Create 2024/2/21 12:31
 * @Version 1.0
 */
public class Main{
    public static void main(String[] args) {
        // 确保包含必填命令行参数
        ParameterCheckerUtil<MyCommandLine> checker = new ParameterCheckerUtil<>();
//        args = checker.includeIfMissing(MyCommandLine.class, args);
        // 7.在 main 方法中，通过 CommandLine 对象的 execute 方法来处理用户输入的命令，剩下的就交给 Picocli 框架来解析命令并执行业务逻辑。
        int exitCode = new CommandLine(new MyCommandLine())
                // 添加子命令
                .addSubcommand(new CreateCommandLine())
                .addSubcommand(new UpdateCommandLine())
                .addSubcommand(new ReadCommandLine())
                .addSubcommand(new DeleteCommandLine())
                .execute(args);
        // 8.CommandLine.execute 方法返回一个退出代码。可以调用 System.exit 并将该退出代码作为参数，从而向调用进程表示成功或失败。
        System.exit(exitCode);
    }
}
