package net.codingtech.common.config;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration //必须存在
@EnableSwagger2 //必须存在
/*@EnableWebMvc*/
//@ComponentScan(basePackages = {"net.codingtech.controller"})
//必须存在 扫描的API Controller package name 也可以直接扫描class (basePackageClasses)
public class SwaggerConfig /*extends WebMvcConfigurerAdapter*/ {

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }*/
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("net.codingtech.controller"))
                .build()
                ;
    }

    @Bean
    public Docket defaultDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("controller")
//                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage(BasicErrorController.class.getPackage().getName()))
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("稚园API接口大全")
                .description("前台以及后台API接口")
                .contact("豆町科技")
                .version("1.0")
                .build();
    }
}

