package com.developer.mousika.utils;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;

public class GlobalConfigUtil {
    /**
     * 数据源配置
     */
    public static GlobalConfig getGlobalConfig(String outputDir, String author) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setAuthor(author);
        gc.setOpen(false);
        // 是否覆盖文件
        gc.setFileOverride(true);
        // 开启 activeRecord 模式
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        //.setKotlin(true) 是否生成 kotlin 代码
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setEntityName("%sEntity");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sResource");
        return gc;
    }
}
