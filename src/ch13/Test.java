package ch13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date date = new Date();
        // format()方法可以将Date类型格式化为字符串
        String dateStr = sdf.format(date);
        System.out.println(dateStr);
        Date newDate = sdf.parse(dateStr);
        System.out.println(newDate);
    }
}
