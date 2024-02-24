package com.feng;

import com.feng.command.CommandExecutor;

/**
* ClassName: Main
* Package: com.feng
* Description: 
* @Author Fengxd
* @Create 2024/2/18 21:29 
* @Version 1.0
*/
public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.execute(args);
    }
}