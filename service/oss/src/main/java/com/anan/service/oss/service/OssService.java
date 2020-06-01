package com.anan.service.oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * @Author: anan
 * @Date: 2020/5/31 22:28
 */
public interface OssService {

  //创建存储空间
  void create();

  //上传文件
  String upload(MultipartFile file);

  //下载文件
  void download();

  //列举文件
  void list();

  //删除文件
  void delete();



}
