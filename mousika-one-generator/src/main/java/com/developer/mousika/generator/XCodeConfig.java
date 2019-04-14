package com.developer.mousika.generator;

public class XCodeConfig {

    public final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public final static String DB_NAME = "mousika";
    public final static String USER_NAME = "root";
    public final static String PASS_WORD = "1234";
    public final static String SERVICE_URL = "127.0.0.1";
    public final static String SERVICE_PORT = "3306";
    public final static String URL = "jdbc:mysql://" + SERVICE_URL + ":" + SERVICE_PORT + "/" + DB_NAME + "?characterEncoding=utf8&serverTimezone=UTC";
    public final static String SCHEMA_NAME = "public";

    public final static String AUTHOR_NAME = System.getProperty("user.name");

    public final static String DEFAULT_ROOT_DIR_JAVA = "/src/main/java";
    public final static String DEFAULT_ROOT_DIR_RESOURCE = "/src/main/resources";
}
