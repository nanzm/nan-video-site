package cn.nancode.zm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * 配置类（可配置很多功能 如拦截器）
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    //统一异常处理
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        exceptionResolvers.add(new HandlerExceptionResolver() {
//            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
//
//                System.out.println(e);
//
//                return new ModelAndView();
//            }
//
//        });
//    }

    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //registry.addMapping("/**");
    }

}
