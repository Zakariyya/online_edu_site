package com.anan.common;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置类
 *
 * 访问路径
 * localhost:port/swagger-ui.html
 *
 * @Author: anan
 * @Date: 2020/5/11 15:44
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket webApiConfig(){
    return new Docket(DocumentationType.SWAGGER_2)
      .groupName("webApi")
      .apiInfo(webApiInfo())
      .select()
      .paths(Predicates.not(PathSelectors.regex("/admin/.*")))// “not” 如果接口路径上如果包含 admin 就不进行显示，下行同理
      .paths(Predicates.not(PathSelectors.regex("/error.*")))
      .build();

  }

  private ApiInfo webApiInfo(){

    return new ApiInfoBuilder()
      .title("在线教育 - API文档")
      .description("在线教育接口定义")
      .version("1.0")
      .contact(new Contact("java", "http://github.com/Zakariyya", "ruanmeng@yyy.com"))
      .build();
  }

}
