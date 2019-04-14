package com.developer.mousika.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.developer.mousika.config.*;
import com.developer.mousika.config.po.TableFill;
import com.developer.mousika.config.rules.NamingStrategy;
import com.developer.mousika.utils.ConverterUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成
 */
public class XCodeGenerator {

    public AutoGenerator generator(String moduleName, String outPackage, String outDir, String tableName) {

        //应全部为小写字母和数字组成(遵循编程规范)
        // ConverterUtil.underline2Camel(tableName)
        String modelName = tableName.replace("-", "").replace("_", "").toLowerCase();
        String resourceName = ConverterUtil.underline2Camel(tableName);
        //输出文件目录
        String outputDir = new File(moduleName + XCodeConfig.DEFAULT_ROOT_DIR_JAVA).getAbsolutePath();
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        //tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator()
                .setGlobalConfig(
                        // 全局配置
                        new GlobalConfig()
                                //输出目录
                                .setOutputDir(outputDir)
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
                                .setAuthor(XCodeConfig.AUTHOR_NAME)
                                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                                .setEntityName("%s")
                                .setMapperName("%sMapper")
                                .setXmlName("%sMapper")
                                .setServiceName("%sService")
                                .setServiceImplName("%sServiceImpl")
                                .setControllerName("%sResource")
                                .setDtoName("%sDTO")
                                .setMapStructName("%sMapStruct")
                                .setAngluarEntityName("%sEntity")
                                .setAngluarHttpServiceName("%sService")
                ).setDataSource(
                        // 数据源配置
                        new DataSourceConfig()
                                // 数据库类型
                                .setDbType(DbType.MYSQL)
                                .setSchemaName(XCodeConfig.SCHEMA_NAME)
                                .setDriverName(XCodeConfig.DRIVER_NAME)
                                .setUsername(XCodeConfig.USER_NAME)
                                .setPassword(XCodeConfig.PASS_WORD)
                                .setUrl(XCodeConfig.URL)
                ).setStrategy(
                        // 策略配置
                        new StrategyConfig()
                                // 全局大写命名
                                // .setCapitalMode(true)
                                //全局下划线命名
                                // .setDbColumnUnderline(true)
                                .setTablePrefix(new String[]{})
                                // 表名生成策略
                                .setNaming(NamingStrategy.underline_to_camel)
                                // 需要生成的表
                                .setInclude(new String[]{tableName})
                                // 排除生成的表
                                // .setExclude(new String[]{"test"})
                                // 自定义实体父类
                                .setSuperEntityClass(outPackage + ".base.entity.BaseEntity")
                                .setSuperDtoClass(outPackage + ".base.dto.BaseDTO")
                                .setSuperMapStructClass(outPackage + ".base.mapstruct.BaseMapStruct")
                                // 自定义 service 父类
                                .setSuperServiceClass(outPackage + ".base.service.BaseService")
                                // 自定义 service 实现类父类
                                .setSuperServiceImplClass(outPackage + ".base.service.impl.BaseServiceImpl")
                                // 自定义 controller 父类
                                .setSuperResourceClass(outPackage + ".base.resource.BaseResource")
                                .setResourceName(resourceName)
                                // 自定义实体，公共字段
                                //.setSuperEntityColumns(new String[]{"test_id"})
                                .setTableFillList(tableFillList)
                                // 自定义 mapper 父类
                                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
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
                        new PackageConfig()
                                // 包路径
                                .setParent(outPackage + "." + outDir + "." + modelName)
                                .setEntity("domain")
                                .setDto("dto")
                                .setMapper("mapper")
                                .setMapStruct("mapstruct")
                                .setService("service")
                                .setServiceImpl("service.impl")
                                .setResource("web.rest")
                                .setController("web.webservice")
                                .setXml("mapper." + modelName)
                                .setAngluarEntity("angluar.entity")
                                .setAngluarHttpService("angluar.http")
                ).setTemplate(
                        new TemplateConfig()
                                .setEntity("/templates/entity.java.vm")
                                .setDto("/templates/dto.java.vm")
                                .setMapper("/templates/mapper.java.vm")
                                .setMapStruct("/templates/mapStruct.java.vm")
                                .setService("/templates/service.java.vm")
                                .setServiceImpl("/templates/serviceImpl.java.vm")
                                .setResource("/templates/resource.java.vm")
                                .setController("/templates/controller.java.vm")
                                .setXml("/templates/mapper.xml.vm")
                                .setAngluarEntity("/templates/entity.ts.vm")
                                .setAngluarHttpService("/templates/httpService.ts.vm"));
        return mpg;
    }
}
