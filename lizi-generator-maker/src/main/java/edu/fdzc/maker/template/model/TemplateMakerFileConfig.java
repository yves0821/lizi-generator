package edu.fdzc.maker.template.model;

import edu.fdzc.maker.meta.Meta;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class TemplateMakerFileConfig {

    private List<FileInfoConfig> files;
    private FileGroupConfig fileGroupConfig;

    @NoArgsConstructor
    @Data
    public static class FileInfoConfig {

        private String path;

        private List<FileFilterConfig> filterConfigList;
    }

    @Data
    public static class FileGroupConfig {

        private String groupKey;

        private String groupName;

        private String condition;
    }
}
