package com.feng.command.children;

import com.feng.consoletable.ConsoleTable;
import com.feng.consoletable.table.Cell;
import com.feng.model.CommandParamInfo;
import picocli.CommandLine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ConfigCommand
 * Package: com.feng.command
 * Description:
 * 输出允许用户传入的动态参数的信息
 * @Author Fengxd
 * @Create 2024/2/22 16:45
 * @Version 1.0
 */
@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        List<CommandParamInfo> commandParamInfos = getCommandParamInfos();
        // 表头
        List<Cell> header = new ArrayList<>();
        header.add(new Cell("参数名"));
        header.add(new Cell("描述"));
        header.add(new Cell("必选"));
        header.add(new Cell("默认值"));
        // 表体
        List<List<Cell>> body = new ArrayList<>();
        commandParamInfos.forEach(info -> {
            // 表内容
            List<Cell> row = new ArrayList<>();
            row.add(new Cell(info.getAuthor()));
            row.add(new Cell(info.getDescription()));
            row.add(new Cell(info.getRequired().toString()));
            row.add(new Cell(info.getDefaultValue()));
            body.add(row);
        });
        // 创建并输出表格
        new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).build().print();
    }

    /**
     * 获取命令参数信息
     * @return 命令参数信息
     */
    private List<CommandParamInfo> getCommandParamInfos() {
        Field[] fields = GenerateCommand.class.getDeclaredFields();
        List<CommandParamInfo> commandParamInfos = new ArrayList<>();
        Arrays.stream(fields).forEach(field -> {
            CommandParamInfo commandParamInfo = new CommandParamInfo();
            commandParamInfo.setAuthor(field.getName());
            CommandLine.Option option = field.getAnnotation(CommandLine.Option.class);
            commandParamInfo.setDescription(option.description()[0]);
            commandParamInfo.setRequired(option.required());
            commandParamInfo.setDefaultValue(option.defaultValue());
            commandParamInfos.add(commandParamInfo);
        });
        return commandParamInfos;
    }
}
