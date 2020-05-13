package com.anan.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: anan
 * @Date: 2020/5/11 14:41
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.anan"}) // 设置包扫描的规则
public class EduApplication {

  public static void main(String[] args) {
    SpringApplication.run(EduApplication.class, args);
  }

}
