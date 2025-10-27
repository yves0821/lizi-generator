package edu.fdzc.maker.generator;

import java.io.*;

public class JarGenerator {
    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        //清理之前的构建并打包
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavemCommand = winMavenCommand;

        ProcessBuilder processBuilder = new ProcessBuilder(mavemCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        // 读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 等待命令执行完成
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);
    }

}
