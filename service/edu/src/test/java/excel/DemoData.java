package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: anan
 * @Date: 2020/6/4 10:09
 */
@Data
public class DemoData {


  // 设置表头
  @ExcelProperty("学生编号")
  private Integer sno;

  @ExcelProperty("学生姓名")
  private String sname;

}
