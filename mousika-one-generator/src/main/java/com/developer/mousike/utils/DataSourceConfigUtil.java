package com.developer.mousike.utils;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

public class DataSourceConfigUtil {

    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "1234";
    private static String serviceUrl = "127.0.0.1";
    private static String servicePort = "3306";
    private static String dbName = "mousika";

    /**
     * 数据源配置
     */
    public static DataSourceConfig getDataDataSourceConfig() {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://" + serviceUrl + ":" + servicePort + "/" + dbName + "?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        return dsc;
    }
}
