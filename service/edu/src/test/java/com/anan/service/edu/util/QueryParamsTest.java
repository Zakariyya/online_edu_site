package com.anan.service.edu.util;

import com.anan.service.edu.orm.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

//import org.springframework.boot.test.context.SpringBootTest;

/**
 * 条件拼接测试类
 * @Author: anan
 * @Date: 2020/5/13 14:54
 */
@Slf4j
class QueryParamsTest {

  /**
   * 多条件查询的拼接、校空
   */
  @Test
  public void aa(){

//    QueryWrapper qw = new QueryWrapper();
    Teacher t = new Teacher();
    t.setLevel(1);
    t.setName("aa");

    //遍历类属性
    //判空后拼接
    String[] filedName = this.getFiledName(t);
    System.out.println(filedName);

  }


  public <T> void mergeObject(T origin, T destination) {
    if (origin == null || destination == null)
      return;
    if (!origin.getClass().equals(destination.getClass()))
      return;

    Field[] fields = origin.getClass().getDeclaredFields();

    for (int i = 0; i < fields.length; i++) {
      try {
        fields[i].setAccessible(true);
        Object value = fields[i].get(origin);

        if (null != value) {
          fields[i].set(destination, value);
        }
        fields[i].setAccessible(false);
      } catch (Exception e) {
      }
    }
  }

  /**
   * 获取属性名数组
   * */
  private String[] getFiledName(Object o){
    Field[] fields=o.getClass().getDeclaredFields();
    String[] fieldNames=new String[fields.length];
    try {
      for(int i=0;i<fields.length;i++){
        fields[i].setAccessible(true);
        System.out.println(fields[i].getType());
        fieldNames[i]=fields[i].getName();
        Object o1 = fields[i].get(o);
        System.out.println("o1 = "+ o1+" ::::: fieldNames[i]= "+fieldNames[i]);
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return fieldNames;
  }



}

