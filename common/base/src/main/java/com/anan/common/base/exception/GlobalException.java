package com.anan.common.base.exception;

import com.anan.common.base.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 *
 * @Author: anan
 * @Date: 2020/5/18 16:35
 */
@ControllerAdvice
@Slf4j
public class GlobalException {

  /**
   * 全局异常处理
   * @param e
   * @return
   */
  @ExceptionHandler({Exception.class}) //指定异常
  @ResponseBody  // 为了能返回数据
  public R error(Exception e){
    e.printStackTrace();
    return R.failure("执行了全局异常处理");
  }

  /**
   * 全局 - 自定义异常信息处理
   *
   *   try{
   *     int i = 10 / 0;
   *   }catch(Exception e){
   *     throw new AnanException(20001,"执行了自定义异常");
   *   }
   *
   * @param e
   * @return
   */
  @ExceptionHandler({AnanException.class}) //指定异常
  @ResponseBody  // 为了能返回数据
  public R errorAnan(AnanException e){
    e.printStackTrace();

    // error的话就会写到 log.error.log 里面（配合 logback 使用）
    // log.info(), 就是写到 log.info.log 文件里面
    log.error(e.getMessage());
    log.error(ExceptionUtil.getMessage(e)); // ExceptionUtil 里面将堆栈异常信息打印出来，比直接 e.getMessage() 更加详细

    return R.success().code(e.getCode()).msg(e.getMsg());
  }




}
