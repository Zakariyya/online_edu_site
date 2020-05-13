package com.anan.service.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: anan
 * @Date: 2020/5/11 14:42
 */
@Configuration
@MapperScan("com.anan.service.edu.mapper")
public class EduConfig {



  /**
   * 逻辑删除插件
   */
  @Bean
  public ISqlInjector sqlInjector(){
    return new LogicSqlInjector();
  }

}
