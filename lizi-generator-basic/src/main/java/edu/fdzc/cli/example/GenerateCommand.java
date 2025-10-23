package edu.fdzc.cli.example;

import cn.hutool.core.bean.BeanUtil;
import edu.fdzc.generator.MainGenerator;
import edu.fdzc.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 代码生成命令
 *
 */
@Command(name = "generate", description = "代码生成", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l","--loop"}, description = "是否循环", arity = "0..1", interactive = true, echo = true)
    boolean loop;

    @Option(names = {"-a","--author"}, description = "作者", arity = "0..1", interactive = true, echo = true)
    String author = "lizi";

    @Option(names = {"-o","--outputText"}, description = "输出信息", arity = "0..1", interactive = true, echo = true)
    String outputText = "Sum = ";

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息情况如下" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }

}
