package com.developer.mousika;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.developer.mousika.generator.XCodeGenerator;
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

        modelName = ConverterUtil.underline2Camel(table);
//        table_prefix = table.substring(0, table.indexOf("_") + 1);
        table_prefix = "";
        resource = table.replaceAll("_", "-");
        outPutUrl = packageName + "/src/main/java";
        //执行生成操作
        new XCodeGenerator().generator(modelName, table, table_prefix, resource, outPutUrl, outPackage).execute();

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
