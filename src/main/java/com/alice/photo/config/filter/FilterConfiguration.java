//package com.alice.photo.config.filter;
//
//import com.alice.photo.common.filter.AdminFilter;
//import com.alice.photo.common.filter.LoginFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class FilterConfiguration {
//    @Bean
//    public FilterRegistrationBean filterAdminRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        //注入过滤器
//        registration.setFilter(new AdminFilter());
//        //拦截规则
//        registration.addUrlPatterns("/manage/page/*","/manage/home.html","/manage/index.html");
//        //过滤器名称
//        registration.setName("AdminFilter");
//        //是否自动注册 false 取消Filter的自动注册
//        registration.setEnabled(true);
//        //过滤器顺序
//        registration.setOrder(2);
//        return registration;
//    }
//    @Bean
//    public FilterRegistrationBean filterLoginRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        //注入过滤器
//        registration.setFilter(new LoginFilter());
//        //拦截规则
//        registration.addUrlPatterns("/member.html");
//        //过滤器名称
//        registration.setName("LoginFilter");
//        //是否自动注册 false 取消Filter的自动注册
//        registration.setEnabled(true);
//        //过滤器顺序
//        registration.setOrder(1);
//        return registration;
//    }
//
//}
