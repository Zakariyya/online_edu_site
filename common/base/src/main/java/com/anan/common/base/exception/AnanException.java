package com.anan.common.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 *
 * @Author: anan
 * @Date: 2020/5/18 18:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnanException extends RuntimeException{
  private Integer code; //状态码
  private String msg; //异常信息

}
