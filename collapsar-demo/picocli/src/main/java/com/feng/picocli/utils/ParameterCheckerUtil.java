package com.feng.picocli.utils;

import picocli.CommandLine;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

/**
 * ClassName: ForcedInteraction
 * Package: com.feng.picocli.utils
 * Description:
 * 如果用户输入的参数不包含必填参数就补全必填参数
 * @Author Fengxd
 * @Create 2024/2/21 15:11
 * @Version 1.0
 */
public class ParameterCheckerUtil<T> {
    /**
     *
     * @param clazz picocli 命令行类
     * @param args 用户输入的命令行参数
     * @return 包含必填参数的参数数组
     */
    public String[] includeIfMissing(Class<T> clazz, String[] args) {
        String[] requiredParams = requiredParams(clazz);
        return mergeAndDeduplicate(requiredParams, args);
    }

    /**
     * 获取必填参数
     * @param clazz picocli 命令行类
     * @return 必填参数
     */
    private String[] requiredParams(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        // 获取必填选项
        return Arrays.stream(fields)
                // 过滤 Option 注解的字段
                .filter(field -> field.isAnnotationPresent(CommandLine.Option.class))
                // 过滤必填字段
                .filter(field -> field.getAnnotation(CommandLine.Option.class).required())
                // 获取选项名称
                .map(field -> field.getAnnotation(CommandLine.Option.class).names()[0])
                .toArray(String[]::new);
    }

    /**
     * 合并必填参数和用户输入的参数
     * @param requestArgs 必填参数
     * @param inputArgs 用户输入的参数
     * @return 合并后的参数
     */
    private String[] mergeAndDeduplicate(String[] requestArgs, String[] inputArgs) {
        HashSet<String> args = new HashSet<>();
        args.addAll(Arrays.asList(requestArgs));
        args.addAll(Arrays.asList(inputArgs));
        return args.toArray(new String[0]);
    }
}
