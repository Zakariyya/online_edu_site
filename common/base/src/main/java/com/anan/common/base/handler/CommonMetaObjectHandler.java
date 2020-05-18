package com.anan.common.base.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  MyBatis-plus 的自动填充插件
 *
 * @Author: anan
 * @Date: 2020/5/18 15:46
 */
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {


  @Override
  public void insertFill(MetaObject metaObject) {
    // 属性名称，不是字段名称
    this.setFieldValByName("gmtCreate", new Date(), metaObject);
    this.setFieldValByName("gmtModified", new Date(), metaObject);

  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("gmtModified", new Date(), metaObject);
  }
}
