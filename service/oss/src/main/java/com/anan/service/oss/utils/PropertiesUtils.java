package com.anan.service.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 当项目启动，Spring接口，spring加载之后，执行接口一个方法
 * @Author: anan
 * @Date: 2020/5/31 18:02
 */
@Component
public class PropertiesUtils implements InitializingBean {

/**
 * 读取配置文件的内容
 *
 *  aliyun:
 *   oss:
 *     file:
 *
 *   String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
 *   // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
 *   String accessKeyId = "<yourAccessKeyId>";
 *   String accessKeySecret = "<yourAccessKeySecret>";
 *   String bucketName = "<yourBucketName>";
 */
   @Value("${aliyun.oss.file.endpoint}")
  private String endpoint;

  @Value("${aliyun.oss.file.accessKeyId}")
  private String accessKeyId;

  @Value("${aliyun.oss.file.accessKeySecret}")
  private String accessKeySecret;

  @Value("${aliyun.oss.file.bucketName}")
  private String bucketName;


  //定义公开静态常量
  public static String END_POIND;
  public static String ACCESSKEY_ID;
  public static String ACCESS_KEY_SECRET;
  public static String BUCKET_NAME;


  @Override
  public void afterPropertiesSet() throws Exception {
    END_POIND = endpoint ;
    ACCESSKEY_ID = accessKeyId ;
    ACCESS_KEY_SECRET = accessKeySecret ;
    BUCKET_NAME = bucketName ;
  }
}
