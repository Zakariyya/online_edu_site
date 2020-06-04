package com.anan.service.edu.controller;


import com.anan.common.base.utils.R;
import com.anan.service.edu.orm.EduSubject;
import com.anan.service.edu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author anan/CodeGenerator
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/subject")
@CrossOrigin
public class EduSubjectController {

  @Autowired
  private EduSubjectService service;

  //添加课程分类
  //获取上传过来文件，把文件内容读取出来
  @PostMapping
  public R uploadSubject(MultipartFile file) {
    //上传过来的excel文件
    service.saveSubject(file,service);

    return R.success();
  }



}

