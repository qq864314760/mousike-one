package com.developer.mousika.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * conversion 工具类
 *
 * @author
 * @date 2018-03-13
 */
public class ConverterUtil {

    private static final Pattern PATTERN_UNDERLINE = Pattern.compile("([A-Za-z\\d]+)(_)?");

    private static final Pattern PATTERN_CAMEL = Pattern.compile("[A-Z]([a-z\\d]+)?");

    /**
     * 下划线转驼峰
     *
     * @param source 要转换的字符串
     * @return
     */
    public static String underline2Camel(String source) {
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Matcher matcher = PATTERN_UNDERLINE.matcher(source);
        while (matcher.find()) {
            String word = matcher.group();
            //匹配到到第一个字符串首字母小写
            sb.append(matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     *
     * @param source 要转换的字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String source) {
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        //首字母转成大写
        source = String.valueOf(source.charAt(0)).toUpperCase().concat(source.substring(1));
        StringBuffer sb = new StringBuffer();
        Matcher matcher = PATTERN_CAMEL.matcher(source);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toLowerCase());
            sb.append(matcher.end() == source.length() ? "" : "_");
        }
        return sb.toString();
    }
}
