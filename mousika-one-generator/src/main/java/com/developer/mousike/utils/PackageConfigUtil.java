package com.developer.mousike.utils;

import com.baomidou.mybatisplus.generator.config.PackageConfig;

public class PackageConfigUtil {
    /**
     * 数据源配置
     */
    public static PackageConfig getPackageConfig(String moduleName, String parent) {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(parent);
        return pc;
    }
}
