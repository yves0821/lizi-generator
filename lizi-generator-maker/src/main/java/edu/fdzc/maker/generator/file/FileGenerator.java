package edu.fdzc.maker.generator.file;


import edu.fdzc.maker.model.Datamodel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class FileGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();

        // 输入路径
        String inputPath = new File(parentFile, "lizi-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;

        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        // 生成动态文件
        String inputDynamicPath = projectPath + File.separator + "src\\main\\resources\\templates\\MainTemplate.java.ftl";
        String outputDynamicPath = projectPath + File.separator + "acm-template\\src\\com\\yupi\\acm\\MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicPath, outputDynamicPath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        Datamodel datamodel = new Datamodel();
        datamodel.setAuthor("lizi");
        datamodel.setLoop(true);
        datamodel.setOutputText("输出信息为");
        doGenerate(datamodel);
    }
}

