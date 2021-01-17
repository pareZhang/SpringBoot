package com.zjm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author pareZhang
 * @Date 2021/1/17 19:38
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zjm.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .description("swagger接口测试文档")
                        .contact(new Contact("parezhang的GitHub", "https://github.com/pareZhang", "parezhang@126.com"))
                        .version("1.0")
                        .title("API测试文档")
                        .license("Apache2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                        .build()
                );
    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("质量安全管理")
//                .description("质量安全管理 API")
//                .version("1.0")
//                .build();
//    }
}
