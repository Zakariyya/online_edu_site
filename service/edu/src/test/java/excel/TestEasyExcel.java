package excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: anan
 * @Date: 2020/6/4 10:16
 */
public class TestEasyExcel {

  public static void main(String[] args) {
    //实现excel写的操作
    //1. 设置写入文件夹地址和excel文件名称
//    String fileName = "D:/Desktop/1.xlsx";

    //2.调用easyexcel里面的方法实现与操作
//    EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());

    //实现excel读操作
    String fileName = "D:/Desktop/1.xlsx";

    EasyExcel.read(fileName, DemoData.class, new ExcelListener()).sheet().doRead();


  }

  private static List<DemoData> getData(){
    List<DemoData> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      DemoData data = new DemoData();
      data.setSno(i);
      data.setSname("lucy"+i);
      list.add(data);

    }
    return list;

  }



}
