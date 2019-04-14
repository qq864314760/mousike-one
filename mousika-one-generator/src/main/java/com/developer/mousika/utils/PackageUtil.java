package com.developer.mousika.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Scanner;

public class PackageUtil {
    /**
     * 获取项目包名
     *
     * @param sc
     */
    public static String getText(Scanner sc) {
        String text = sc.next();
        if (StringUtils.isEmpty(text)) {
            System.out.println("输入内容不能为空!");
            text = getPackageName(sc);
        }
        return text;
    }
    /**
     * 获取项目包名
     *
     * @param sc
     */
    public static String getPackageName(Scanner sc) {
        String name = sc.next();
        File file = new File(name);
        if (!file.exists()) {
            System.out.println("名称不存在,请重新输入!");
            name = getPackageName(sc);
        }
        return name;
    }
}
