package com.anan.common.base.exception;

import com.anan.common.base.utils.R;
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

}
