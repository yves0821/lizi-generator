package edu.fdzc.maker.model;

import lombok.Data;

/**
 * 数据模型
 */
@Data
public class Datamodel {

    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "lizi";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";
}
