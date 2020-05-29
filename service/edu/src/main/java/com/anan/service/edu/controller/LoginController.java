package com.anan.service.edu.controller;

import com.anan.common.base.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: anan
 * @Date: 2020/5/21 17:31
 */
@Api(tags = {"登录"})
@RestController
@RequestMapping("/user")
@CrossOrigin
public class LoginController {


  //login
  @ApiOperation(value = "用户登录")
  @PostMapping("login")
  public R login(){
    return R.success().data("token","admin");
  }

  //info
  @ApiOperation(value = "获取用户信息")
  @GetMapping("info")
  public R info(){
    return R.success().data("roles","[admin]")
      .data("name","admin")
      .data("avatar","https://avatars1.githubusercontent.com/u/14139937?s=460&u=7cec8d3529caf05ef1cae015cd91a40a71ad6839&v=4");
  }



}
