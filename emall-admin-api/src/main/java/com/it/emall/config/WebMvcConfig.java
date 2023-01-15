package com.it.emall.config;

/**
 * @author libingyang
 * @create 2023/1/13 23:04
 */

import com.it.emall.constants.FileUploadConstants;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVC相关配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 把资源的访问路径和资源的存储位置映射起来
        registry.addResourceHandler(FileUploadConstants.FILE_URL + "**")
                .addResourceLocations("file:" + FileUploadConstants.SAVE_DIR);
    }


    /**
     * 添加跨域对象
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .maxAge(1800);
    }
}
