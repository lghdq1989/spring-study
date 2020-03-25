package com.midea.logistics.applcation.mobile.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author ex_lianggang
 * @Date 2020/3/25 8:54
 * @Version 1.0
 */

public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    public  String cookie;
    public FeignBasicAuthRequestInterceptor() {

    }

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration em = request.getParameterNames();
        Properties prop = new Properties();
        ClassPathResource fileRource = new ClassPathResource("config.properties");
        try {
                PropertiesConfiguration config = new PropertiesConfiguration(fileRource.getPath());
                while (em.hasMoreElements()) {
                    String name = (String) em.nextElement();
                    String value = request.getParameter(name);
                        if("Cookie".equals(name)) {

                            writeData("cookie",value);


                        }
                    }

                cookie=config.getString("cookie");
                 System.out.println(cookie);
                template.header("Cookie", cookie);
            }catch (Exception e){
                 System.out.println(e);
             }finally {

          }


    }

    /**
     * 修改或添加键值对 如果key存在，修改 反之，添加。
     *
     * @param key
     * @param value
     */
    public static void writeData(String key, String value) {
        Properties prop = new Properties();
        ClassPathResource fileRource = new ClassPathResource("config.properties");
        try {
            PropertiesConfiguration config = new PropertiesConfiguration(fileRource.getPath());
            config.setProperty(key,value);
            config.save();
        } catch ( ConfigurationException e) {
            System.out.println(e);
        }
    }

}
