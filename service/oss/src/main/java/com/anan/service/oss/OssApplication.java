package com.anan.service.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author: anan
 * @Date: 2020/5/11 14:41
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.anan"}) // 设置包扫描的规则
public class OssApplication {

  public static void main(String[] args) {
    SpringApplication.run(OssApplication.class, args);
  }

}
