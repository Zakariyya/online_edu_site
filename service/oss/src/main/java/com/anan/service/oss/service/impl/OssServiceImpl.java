package com.anan.service.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.anan.service.oss.service.OssService;
import com.anan.service.oss.utils.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * OSS Service
 *
 * 参考
 * https://help.aliyun.com/document_detail/32011.html?spm=a2c4g.11186623.6.772.64466328HfmHLN
 *
 * @Author: anan
 * @Date: 2020/5/31 22:28
 */
@Slf4j
@Service
public class OssServiceImpl implements OssService {

  static String endpoint;
  static String accessKeyId;
  static String accessKeySecret;
  static String bucketName;


 private static void  get(){
   endpoint = PropertiesUtils.END_POIND;
   /**
    *   阿里云主账号AccessKey拥有所有API的访问权限，
    *   风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，
    *   请登录 https://ram.console.aliyun.com 创建RAM账号。
    */
   accessKeyId = PropertiesUtils.ACCESSKEY_ID;

   accessKeySecret = PropertiesUtils.ACCESS_KEY_SECRET;
   bucketName = PropertiesUtils.BUCKET_NAME;
 }


  @Override
  public void create() {
    get();
// 创建OSSClient实例。
    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建存储空间。
    ossClient.createBucket(bucketName);

// 关闭OSSClient。
    ossClient.shutdown();
  }

  @Override
  public String upload(MultipartFile file) {
    get();
    try {
      String url;

      // 创建OSSClient实例。
      OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

      // 上传文件流。
      InputStream inputStream = file.getInputStream();
      String fileName = file.getOriginalFilename();

      // 第二个参数 ，上传到OSS文件路径和文件名称 /aa/bb/1.jpg
      // 第三个参数，上传文件输入流
      ossClient.putObject(bucketName, fileName, inputStream);

      // 关闭OSSClient。
      ossClient.shutdown();

      //把上传之后文件路径返回，把上传到阿里云OSS路径手动拼接出来
      //https://bucketName.endpoint/filename

      url = "https://" + bucketName + "." + endpoint + "/" + fileName;
      return url;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void download() {

  }

  @Override
  public void list() {

  }

  @Override
  public void delete() {

  }
}
