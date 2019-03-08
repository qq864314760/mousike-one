package com.developer.mousika.config;

import java.io.File;
import java.net.URI;

/**
 * Application constants.
 */
public final class BaseConstants {

    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "zh-cn";
    public static final String VERSION_LOCK_MESSAGE = "更新数据时数据已被修改，乐观锁异常";
    public static final String INSERT_ERROR_MESSAGE = "添加数据失败";
    public static final String INSERT_ERROR_CODE = "INSERTERR";
    public static final String VERSION_LOCK_CODE = "VLOCKERR";

    public static final String USER_HOME = System.getProperty("user.home");
}
