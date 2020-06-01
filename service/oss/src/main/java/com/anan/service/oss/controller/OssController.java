package com.anan.service.oss.controller;

import com.anan.common.base.utils.R;
import com.anan.service.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: anan
 * @Date: 2020/5/31 22:27
 */
@RestController
@RequestMapping("/oss/fileoss")
@CrossOrigin
@Api(tags = {"OSS上传"})
public class OssController {

  @Autowired
  OssService ossService;

  @ApiOperation(value = "上传")
  @PostMapping
  public R upload(MultipartFile file) {
    String url = ossService.upload(file);

    return R.success(url);
  }



}
