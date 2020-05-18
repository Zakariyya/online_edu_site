package com.anan.common.base.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果 类
 *
 * @Author: anan
 * @Date: 2020/5/12 12:27
 */
@Data
// jackson 的包，忽略属性
@JsonIgnoreProperties(value = { "map" })
public class R<T> {

  @ApiModelProperty(value = "返回码")
  private Integer code;

  @ApiModelProperty(value = "返回数据")
  private T data;

  @ApiModelProperty(value = "返回消息")
  private String msg;

  // 这个map是为了装data的，全局变量是为了可以放多个 .data().data()
  private Map<String, Object> map = new HashMap<>();

  private R() {}

  public static R success(){
    R r = new R();
    r.setCode(ResultCode.SUCCESS);
    return r;
  }

  public static R success(Object data){
    R r = new R();
    r.setCode(ResultCode.SUCCESS);
    r.setData(data);
    return r;
  }

  public static R success(Boolean flag, String msg) {
    R r = new R();
    if (flag)
      return success();
    else
      return failure(msg);
  }

  public static R failure(String msg){
    R r = new R();
    r.setCode(ResultCode.FAILRUE);
    r.setMsg(msg);
    return r;
  }

  public R code(Integer code) {
    this.setCode(code);
    return this;
  }

  public R data(Object data) {
    this.setData((T)data);
    return this;
  }

  public R data(Map<String, Object> data) {
    this.setData((T)data);
    return this;
  }

  public R data(String key, Object value) {
    map.put(key, value);
    this.setData((T)map);
    return this;
  }

}
