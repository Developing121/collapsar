package com.feng.command.children;

import com.feng.consoletable.ConsoleTable;
import com.feng.consoletable.table.Cell;
import com.feng.model.FileInfo;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String projectPath = System.getProperty("user.dir");
        // 获取文件列表
        String[] templateFileList = new File(projectPath + File.separator + "collapsar").list();
        // 黑洞项目的根路径
        String templatePath = projectPath + File.separator + "collapsar-generator-template" + File.separator + "collapsar" + File.separator;
        // 遍历文件列表
        FileInfo[] fileInfos = Arrays.stream(templateFileList).map(s -> {
            // 创建文件信息对象
            FileInfo info = new FileInfo();
            // 保存文件名到文件信息对象
            info.setFileName(s);
            // 根据文件路径获取文件大小
            Path path = Paths.get(templatePath + File.separator + s);
            try {
                info.setFileSize(Files.size(path) / 1024);
            } catch (IOException e) {
                System.out.println("文件大小获取失败");
                throw new RuntimeException(e);
            }
            return info;
        }).toArray(FileInfo[]::new);
        // 表头
        List<Cell> header = new ArrayList<>();
        header.add(new Cell("文件名"));
        header.add(new Cell("文件大小"));
        // 表体
        List<List<Cell>> body = new ArrayList<>();
        Arrays.stream(fileInfos).forEach(info -> {
            // 表内容
            List<Cell> row = new ArrayList<>();
            row.add(new Cell(info.getFileName()));
            row.add(new Cell(info.getFileSize().toString() + "KB"));
            body.add(row);
        });
        // 创建并输出表格
        new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).build().print();
    }
}

