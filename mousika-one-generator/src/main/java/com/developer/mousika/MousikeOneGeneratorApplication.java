package com.developer.mousika;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.developer.mousika.generator.XCodeConfig;
import com.developer.mousika.generator.XCodeGenerator;
import com.developer.mousika.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class MousikeOneGeneratorApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入输出项目包名，（例如：mousika-one-uaa(默认)）");
        String moduleName = PackageUtil.getPackageName(sc);
        System.out.println("请输入生成的文件输出的包路径，（例如：com.developer.mousika(默认)）");
        String outPackage = PackageUtil.getText(sc);
        System.out.println("请输入生成的文件输出的最后文件夹路径，（例如：controller、service(默认)）");
        String outDir = PackageUtil.getText(sc);
        System.out.println("请输入表名(需要包含前缀),分隔符为\"_\"（例如：auth_user）");
        String tableName = PackageUtil.getText(sc);

        //执行生成操作
        new XCodeGenerator().generator(moduleName, outPackage, outDir, tableName).execute();

        //移动Mapper.xml到resources文件夹下面
        String modelName = tableName.replace("-", "").replace("_", "").toLowerCase();
        String startPath = new File(moduleName + XCodeConfig.DEFAULT_ROOT_DIR_JAVA).getAbsolutePath() + "\\" + outPackage.replace(".", "\\") + "\\" + outDir + "\\" + modelName + "\\mapper\\" + modelName;
        String movePath = new File(moduleName + XCodeConfig.DEFAULT_ROOT_DIR_RESOURCE).getAbsolutePath() + "\\mapper\\";
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
