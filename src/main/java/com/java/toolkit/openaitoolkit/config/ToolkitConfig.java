//package com.java.toolkit.openaitoolkit.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.time.LocalDate;
//
//import static springfox.documentation.builders.PathSelectors.regex;
////@EnableSwagger2
////public class ToolkitConfig {
////
////    @Bean
////    public Docket postsApi(){
////        return new Docket(DocumentationType.SWAGGER_2).groupName("My group Name").apiInfo(apiInfo()).select()
////                .paths(regex("/v1.*")).build();
////    }
////
////    private ApiInfo apiInfo(){
////        return new ApiInfoBuilder().title("Custom Title")
////                .description("Custom Description")
////                .termsOfServiceUrl("Custom Terms of service url")
////                .license("Custom License")
////                .licenseUrl("Custom License Url")
////                .version("1.0")
////                .build();
////
////    }
////}
//
//
//
////@PropertySource(value = { "classpath:log4j.properties" })
////@EnableWebMvc
//@EnableSwagger2
////@ComponentScan(basePackages = "com.java.toolkit.openaitoolkit")
//public class ToolkitConfig implements WebMvcConfigurer {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.java.toolkit.openaitoolkit.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
////
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)  .apiInfo(apiInfo()).directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
////                .useDefaultResponseMessages(false)
////                .select()
////                .apis(RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
////                .build();
////    }
//
////    private ApiInfo apiInfo() {
////        ApiInfo apiInfo = new ApiInfo(
////                "API",
////                "API for xxxx",
////                "API TOS",
////                "Terms of service",
////                "xxx",
////                "License of API",
////                "");
////        return apiInfo;
////    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
