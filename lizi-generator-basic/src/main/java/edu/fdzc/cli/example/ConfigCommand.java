package edu.fdzc.cli.example;

import cn.hutool.core.util.ReflectUtil;
import edu.fdzc.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * 查看配置参数
 */
@Command(name = "config", description = "打印项目参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("打印项目参数信息");
        // 获取所有字段
        Field [] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        // 遍历并打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("--------");
        }
    }
}
