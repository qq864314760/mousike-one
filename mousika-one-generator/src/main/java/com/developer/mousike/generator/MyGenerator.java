package com.developer.mousike.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.developer.mousike.config.PackageConfigs;
import com.developer.mousike.config.StrategyConfigs;
import com.developer.mousike.config.TemplateConfigs;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成
 */
public class MyGenerator {

    public static String PACKAGE_PATH = "com.sinfusi.democracy";
    public static String BASE_PATH = PACKAGE_PATH + ".service.lambda.common.";
    public static String PARENT_PATH = PACKAGE_PATH + ".service.lambda";

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "1234";
    private static String serviceUrl = "10.102.230.7";
//    private static String driverName = "org.postgresql.Driver";
//    private static String username = "dws_service";
//    private static String password = "inf$#%29KID";
//    private static String serviceUrl = "10.102.100.189";


    public static String packageName;
    private static File file;
    private static String path;
    private static String authorName = "system";

    public AutoGenerator generator(String modelName, String table, String table_prefix, String resource, String outPutUrl, String outPackage) {
        if (StringUtils.isNotEmpty(outPackage)) {
            PARENT_PATH = outPackage;
        }
        packageName = outPutUrl;
        file = new File(packageName);
        path = file.getAbsolutePath();
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        //tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        //输出目录
                        .setOutputDir(path)
                        // 是否覆盖文件
                        .setFileOverride(true)
                        .setOpen(false)
                        // 开启 activeRecord 模式
                        .setActiveRecord(false)
                        // XML 二级缓存
                        .setEnableCache(false)
                        // XML ResultMap
                        .setBaseResultMap(true)
                        // XML columList
                        .setBaseColumnList(true)
                        //.setKotlin(true) 是否生成 kotlin 代码
                        .setAuthor(authorName)
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        //.setEntityName("%sEntity")
                        .setMapperName("%sMapper")
                        .setXmlName("%sMapper")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sResource")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        // 数据库类型
//                        .setDbType(DbType.MYSQL)
                        .setDbType(DbType.POSTGRE_SQL)
                        /*.setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(globalConfig, fieldType);
                            }
                        })*/
                        .setSchemaName("dw_etl")
                        .setDriverName(driverName)
                        .setUsername(username)
                        .setPassword(password)
//                        .setUrl("jdbc:mysql://" + serviceUrl + ":3306/fls_dev?characterEncoding=utf8")
                        .setUrl("jdbc:postgresql://" + serviceUrl + ":10000/DWS")
        ).setStrategy(
                // 策略配置
                new StrategyConfigs()
                        .setResource(resource)
                        .setSuperDtoClass(BASE_PATH + "dto.BaseDTO")
                        .setSuperMapStructClass(BASE_PATH + "mapstruct.BaseMapStruct")
                        // 全局大写命名
                        // .setCapitalMode(true)
                        //全局下划线命名
                        // .setDbColumnUnderline(true)
                        .setTablePrefix(new String[]{table_prefix})
                        // 表名生成策略
                        .setNaming(NamingStrategy.underline_to_camel)
                        // 需要生成的表
                        .setInclude(new String[]{table})
                        // 排除生成的表
                        // .setExclude(new String[]{"test"})
                        // 自定义实体父类
                        .setSuperEntityClass(PACKAGE_PATH + ".common.entity.BaseEntity")
                        // 自定义实体，公共字段
                        //.setSuperEntityColumns(new String[]{"test_id"})
                        .setTableFillList(tableFillList)
                        // 自定义 mapper 父类
                        // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                        // 自定义 service 父类
                        .setSuperServiceClass(PACKAGE_PATH + ".common.service.BaseService")
                        // 自定义 service 实现类父类
                        .setSuperServiceImplClass(PACKAGE_PATH + ".common.service.impl.BaseServiceImpl")
                        // 自定义 controller 父类
                        .setSuperControllerClass(PACKAGE_PATH + ".common.resource.BaseResource")
                        // 【实体】是否生成字段常量（默认 false）
                        // public static final String ID = "test_id";
                        // .setEntityColumnConstant(true)
                        // 【实体】是否为构建者模型（默认 false）
                        // public User setName(String name) {this.name = name; return this;}
                        // .setEntityBuilderModel(true)
                        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                        .setEntityLombokModel(true)
                        // Boolean类型字段是否移除is前缀处理
                        // .setEntityBooleanColumnRemoveIsPrefix(true)
                        .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfigs()
                        .setDto("dto")
                        .setMapStruct("mapstruct")
                        // 包路径
                        .setParent(PARENT_PATH + "." + modelName)
                        .setController("web.rest")
                        .setEntity("domain")
                        .setMapper("mapper")
                        .setService("service")
                        .setServiceImpl("service.impl")
                        .setXml("mapper." + modelName)
        )/*.setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                        "/templates/mapper.xml" + ((1 == result) ? ".ftl" : ".vm")) {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
                    }
                }))
        )*/.setTemplate(
                new TemplateConfigs()
                        .setDto("/templates/dto.java.vm")
                        .setMapStruct("/templates/mapStruct.java.vm")
                        .setController("/templates/resource.java.vm")
                        .setEntity("/templates/entity.java.vm")
                        .setMapper("/templates/mapper.java.vm")
                        .setXml("/templates/mapper.xml.vm")
                        .setService("/templates/service.java.vm")
                        .setServiceImpl("/templates/serviceImpl.java.vm"));
        return mpg;
    }
}
