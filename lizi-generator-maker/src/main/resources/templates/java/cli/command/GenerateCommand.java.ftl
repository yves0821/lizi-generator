package ${basePackage}.cli.Command;

import cn.hutool.core.bean.BeanUtil;
import ${basePackage}.generator.MainGenerator;
import ${basePackage}.model.DataModel;
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

<#list modelConfig.models as modelInfo>
    @Option(names = {<#if modelInfo.abbr??>"-${modelInfo.abbr}", </#if>"--${modelInfo.fieldName}"}, arity = "0..1", <#if modelInfo.description??>description = "${modelInfo.description}", </#if>interactive = true, echo = true)
    ${modelInfo.type} ${modelInfo.fieldName} <#if modelInfo.defaultValue??>= ${modelInfo.defaultValue?c}</#if>;
</#list>

    @Override
    public Integer call() throws Exception {
        DataModel datamodel = new DataModel();
        BeanUtil.copyProperties(this, datamodel);
        System.out.println("配置信息情况如下" + datamodel);
        MainGenerator.doGenerate(datamodel);
        return 0;
    }

}
