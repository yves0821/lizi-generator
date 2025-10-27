package ${basePackage}.generator;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {

        // 项目根路径
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        // 输入路径
        String inputPath;
        String outputPath;

    <#list fileConfig.files as fileInfo>
        inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
        <#if fileInfo.generateType == "dynamic">
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
        <#else>
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
        </#if>

    </#list>
    }
}

