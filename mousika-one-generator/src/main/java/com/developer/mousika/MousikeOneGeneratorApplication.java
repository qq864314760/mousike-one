package com.developer.mousika;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.developer.mousika.generator.MyGenerator;
import com.developer.mousika.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class MousikeOneGeneratorApplication {
    //模块名字
    private static String modelName;

    //resources 资源访问控制路径
    private static String resource;

    //表名
    private static String table;

    //表名前缀
    private static String table_prefix;

    //输出路径
    private static String outPutUrl;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入输出项目包名，（例如：mousika-one-uaa(默认)）");
        String packageName = PackageUtil.getPackageName(sc);
        System.out.println("请输入生成的文件输出的包路径，（例如：com.developer.mousika.service(默认)）");
        String outPackage = sc.next();
        System.out.println("请输入表名,分隔符为\"_\"（例如：auth_user）");
        String table = sc.next();
//        modelName = ConverterUtil.underline2Camel(table.substring(table.indexOf("_") + 1));
        modelName = ConverterUtil.underline2Camel(table);
//        table_prefix = table.substring(0, table.indexOf("_") + 1);
        table_prefix = "";
        resource = table.replaceAll("_", "-");
        outPutUrl = packageName + "/src/main/java";
        //执行生成操作
        new MyGenerator().generator(modelName, table, table_prefix, resource, outPutUrl, outPackage).execute();

        //移动Mapper.xml到resources文件夹下面
        String startPath = packageName + "/src/main/java/" + outPackage.replaceAll("\\.", "/") + "/" + modelName + "/mapper/" + modelName;
        String movePath = packageName + "/src/main/resources/mapper/";
        System.out.println("==:" + startPath);

        boolean isMoveOk = FileUtil.move(new File(startPath), new File(movePath));
        if (isMoveOk) {
            System.out.println("!!!!!!---移动成功---!!!!!!");
        } else {
            System.out.println("!!!!!!---移动失败---!!!!!!");
        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入输创建人，（例如：developer）");
//        String author = sc.next();
//        System.out.println("请输入输出项目包名，（例如：mousika-one-uaa）");
//        String packageName = PackageUtil.getPackageName(sc);
//        System.out.println("请输入生成的文件输出的包路径，（例如：com.developer.mousika.service）");
//        String outPackage = sc.next();
//        System.out.println("请输入表名,分隔符为\"_\"（例如：auth_user）");
//        String table = sc.next();
//        String modelName = ConverterUtil.underline2Camel(table);
//
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        // 全局配置
//        mpg.setGlobalConfig(GlobalConfigUtil.getGlobalConfig((new File(packageName)).getAbsolutePath(), author));
//        // 数据源配置
//        mpg.setDataSource(DataSourceConfigUtil.getDataDataSourceConfig());
//        // 包配置
//        mpg.setPackageInfo(PackageConfigUtil.getPackageConfig(modelName, outPackage));
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        // String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//        strategy.setInclude(scanner("表名"));
//        strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
