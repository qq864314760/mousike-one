package com.developer.mousika.base.resource;


import com.developer.mousika.security.SecurityUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * 资源控制器基类
 *
 * @author
 */
public class BaseResource {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /**
     * 根据用户名获取当前用户名
     * @return
     */
    public String getCurrentUser(){

        return SecurityUtils.getCurrentUserLogin().get();
    }

    /**
     * 如果Header中没有定义则添加，如果已定义则保持原有value不改变。
     *
     * @param name
     * @param value
     */
    public void addHeader(String name, String value) {

        response.addHeader(name, value);
    }

    /**
     * 如果Header中没有定义则添加，如果已定义则用新的value覆盖原用value值。
     *
     * @param name
     * @param value
     */
    public void setHeader(String name, String value) {

        response.setHeader(name, value);
    }

    /**
     * 根据name获取header信息
     *
     * @param name
     * @return
     */
    public Collection<String> getHeaders(String name) {

        return response.getHeaders(name);
    }

    /**
     * 获取所有的头信息
     *
     * @return
     */
    public Collection<String> getHeaderNames() {

        return response.getHeaderNames();
    }

    /**
     * 设置cookie信息
     *
     * @param cookie
     */
    public void addCookie(Cookie cookie) {

        response.addCookie(cookie);
    }
}
