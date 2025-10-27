package edu.fdzc.maker.generator.file;


import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 动态文件生成
 */
public class DynamicFileGenerator {


    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {

        //new一个configuration对象，参数为freemarker的版号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        //指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        //如果文件和目录不存在，则创建
        if(!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        //生成,要与freemarkder的输出流编码一致
        Writer out = new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8);
        template.process(model, out);


        //关闭
        out.close();
    }


}
