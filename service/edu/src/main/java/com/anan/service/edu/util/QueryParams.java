package com.anan.service.edu.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * 多条件组合的拼接
 * @Author: anan
 * @Date: 2020/5/13 16:25
 */
@Data
public class QueryParams {


  private QueryWrapper qw;


  public enum OP {
    /*大于*/
    GT,
    /*小于*/
    LT,
    /*等于*/
    EQ,
    /*大于等于*/
    GT_EQ,
    /*小于等于*/
    LT_EQ,
    /*不等于*/
    NOT_EQ,
    /*IN*/
    IN,
    /*NOT IN*/
    NOT_IN,
    /*IS NULL*/
    IS_NULL,
    /*IS NOT NULL*/
    IS_NOT_NULL,
    /*以xx开头，相当于LIKE 'xxx%'*/
    START_WITH,
    /*以xx结尾，相当于LIKE '%xxx'*/
    END_WITH,
    /*包含，相当于LIKE '%xxx%'*/
    INCLUDE,
    /*不以xx开头，相当于NOT LIKE 'xxx%'*/
    NOT_START_WITH,
    /*不以xx结尾，相当于NOT LIKE '%xxx'*/
    NOT_END_WITH,
    /*不包含，相当于NOT LIKE '%xxx%'*/
    NOT_INCLUDE,
  }


  /**
   * 多条件查询的拼接、校空
   * @param qw
   * @param c : condition
   * @return
   */
  @Deprecated
  public static QueryWrapper like(QueryWrapper qw, Object c){

    //遍历类属性
    //判空后拼接
    Field[] fields = c.getClass().getDeclaredFields();
    String[] fieldNames=new String[fields.length];
    try {
      for(int i=0;i<fields.length;i++){
        fields[i].setAccessible(true);
        fieldNames[i]=fields[i].getName();
        Object o = fields[i].get(c);
        if (o != null)
          qw.like(fieldNames[i], fields[i].get(c));
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return qw;
  }


  public static QueryParams build(QueryWrapper qw) {
    QueryParams wp = new QueryParams();
    wp.setQw(qw);
    return wp;
  }

  public QueryParams like(String colunmName, Object value) {
    if(value != null)
      qw.like(colunmName, value);
    return this;
  }

  public QueryParams eq(String colunmName, Object value) {
    if(value != null)
      qw.eq(colunmName, value);
    return this;
  }

  public QueryParams ge(String colunmName, Object value) {
    if(value != null)
      qw.ge(colunmName, value);
    return this;
  }

  public QueryParams le(String colunmName, Object value) {
    if(value != null)
      qw.le(colunmName, value);
    return this;
  }

  public QueryParams orderByDesc(String colunmName) {
      qw.orderByDesc(colunmName);
    return this;
  }

}
