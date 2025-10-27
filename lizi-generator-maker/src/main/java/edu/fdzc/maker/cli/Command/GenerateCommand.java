package edu.fdzc.maker.cli.Command;

import cn.hutool.core.bean.BeanUtil;
import edu.fdzc.maker.generator.file.FileGenerator;
import edu.fdzc.maker.model.Datamodel;
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
        Datamodel datamodel = new Datamodel();
        BeanUtil.copyProperties(this, datamodel);
        System.out.println("配置信息情况如下" + datamodel);
        FileGenerator.doGenerate(datamodel);
        return 0;
    }

}
